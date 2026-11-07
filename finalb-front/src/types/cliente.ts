export interface ClienteFactura {
  nombreCliente: string;
  apellidoCliente: string;
  nit: string;
  fechaFactura: string; // llega formateada "dd/MM/yyyy HH:mm"
  total: number;
}

export interface ClienteFacturaDetalle {
  nombreCliente: string;
  apellidoCliente: string;
  fechaFactura: string;
  nombreArticulo: string;
  cantidad: number;
  precioUnitario: number;
  subtotal: number;
}
