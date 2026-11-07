import { useRef, useState } from "react";
import "./Reportes.css";
import { generarExcel, generarPDF } from "../utils/exportar";
import { getArticuloCategoria, getArticulosFiltro } from "../services/articuloService";
import { getClienteFactura, getClienteFacturaDetalle } from "../services/clienteService";

export default function Reportes() {
  const dialogNombre = useRef<HTMLDialogElement>(null);
  const [nombre, setNombre] = useState("");

  // ---------- 1. Artículos por nombre (con <dialog>) ----------
  const colArt = ["Nombre", "Marca", "Precio", "Stock"];
  const articulosPDF = async () => {
    const datos = await getArticulosFiltro(nombre);
    await generarPDF(`Artículos que contienen "${nombre}"`, colArt,
      datos.map((a) => [a.nombre, a.marca, a.precio.toFixed(2), a.stock]),
      "articulosNombre.pdf");
  };
  const articulosExcel = async () => {
    const datos = await getArticulosFiltro(nombre);
    await generarExcel(`Artículos que contienen "${nombre}"`, colArt,
      datos.map((a) => [a.nombre, a.marca, a.precio, a.stock]),
      "articulosNombre.xlsx", { anchos: [35, 22, 12, 10], columnasMoneda: [3] });
  };

  // ---------- 2. Artículos con su categoría ----------
  const colAC = ["Artículo", "Marca", "Categoría", "Precio", "Stock"];
  const artCatPDF = async () => {
    const datos = await getArticuloCategoria();
    await generarPDF("Artículos por categoría", colAC,
      datos.map((a) => [a.nombreArticulo, a.marca, a.nombreCategoria, a.precio.toFixed(2), a.stock]),
      "articuloCategoria.pdf");
  };
  const artCatExcel = async () => {
    const datos = await getArticuloCategoria();
    await generarExcel("Artículos por categoría", colAC,
      datos.map((a) => [a.nombreArticulo, a.marca, a.nombreCategoria, a.precio, a.stock]),
      "articuloCategoria.xlsx", { anchos: [35, 22, 22, 12, 10], columnasMoneda: [4] });
  };

  // ---------- 3. Facturas por cliente ----------
  const colFac = ["Cliente", "NIT", "Fecha", "Total"];
  const facturasPDF = async () => {
    const datos = await getClienteFactura();
    await generarPDF("Facturas por cliente", colFac,
      datos.map((f) => [`${f.nombreCliente} ${f.apellidoCliente}`, f.nit, f.fechaFactura, f.total.toFixed(2)]),
      "facturasCliente.pdf");
  };
  const facturasExcel = async () => {
    const datos = await getClienteFactura();
    await generarExcel("Facturas por cliente", colFac,
      datos.map((f) => [`${f.nombreCliente} ${f.apellidoCliente}`, f.nit, f.fechaFactura, f.total]),
      "facturasCliente.xlsx", { anchos: [30, 15, 20, 14], columnasMoneda: [4] });
  };

  // ---------- 4. Detalle de facturas con Total general ----------
  const colDet = ["Cliente", "Fecha", "Artículo", "Cantidad", "Precio unitario", "Subtotal"];
  const detallePDF = async () => {
    const datos = await getClienteFacturaDetalle();
    const total = datos.reduce((suma, d) => suma + d.subtotal, 0);
    await generarPDF("Detalle de facturas por cliente", colDet,
      datos.map((d) => [`${d.nombreCliente} ${d.apellidoCliente}`, d.fechaFactura, d.nombreArticulo,
        d.cantidad, d.precioUnitario.toFixed(2), d.subtotal.toFixed(2)]),
      "facturasDetalle.pdf", ["", "", "", "", "Total general", total.toFixed(2)]);
  };
  const detalleExcel = async () => {
    const datos = await getClienteFacturaDetalle();
    await generarExcel("Detalle de facturas por cliente", colDet,
      datos.map((d) => [`${d.nombreCliente} ${d.apellidoCliente}`, d.fechaFactura, d.nombreArticulo,
        d.cantidad, d.precioUnitario, d.subtotal]),
      "facturasDetalle.xlsx", {
        anchos: [28, 18, 35, 10, 16, 14],
        columnasMoneda: [5, 6],
        filaTotal: (ultima) => ["", "", "", "", "Total general", { formula: `SUM(F5:F${ultima})` }],
      });
  };

  const tarjeta = (titulo: string, descripcion: string, pdf: () => void, excel: () => void) => (
    <div className="tarjeta">
      <h3>{titulo}</h3>
      <p className="descripcion">{descripcion}</p>
      <div className="botones">
        <button className="btn btn-pdf" onClick={pdf}>📄 PDF</button>
        <button className="btn btn-excel" onClick={excel}>📊 Excel</button>
      </div>
    </div>
  );

  return (
    <div className="contenedor">
      <header className="encabezado">
        <h1>🔧 Ferretería</h1>
        <p>Reportes en PDF y Excel</p>
      </header>

      <div className="grid">
        <div className="tarjeta">
          <h3>1. Artículos por nombre</h3>
          <p className="descripcion">Busca artículos activos por su nombre.</p>
          <div className="botones">
            <button className="btn btn-filtro" onClick={() => dialogNombre.current?.showModal()}>🔍 Abrir filtro</button>
          </div>
        </div>
        {tarjeta("2. Artículos con su categoría", "Artículo, marca, categoría, precio y stock.", artCatPDF, artCatExcel)}
        {tarjeta("3. Facturas por cliente", "Cliente, NIT, fecha y total de cada factura.", facturasPDF, facturasExcel)}
        {tarjeta("4. Detalle de facturas", "Artículos vendidos con su total general.", detallePDF, detalleExcel)}
      </div>

      <dialog ref={dialogNombre} className="dialogo">
        <h3>Artículos por nombre</h3>
        <input className="campo" type="text" placeholder="Ej. tornillo" value={nombre}
          onChange={(e) => setNombre(e.target.value)} />
        <div className="botones">
          <button className="btn btn-pdf" onClick={articulosPDF}>📄 Exportar a PDF</button>
          <button className="btn btn-excel" onClick={articulosExcel}>📊 Exportar a Excel</button>
          <button className="btn btn-cerrar" onClick={() => dialogNombre.current?.close()}>Cerrar</button>
        </div>
      </dialog>
    </div>
  );
}
