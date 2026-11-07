import api from "./api";
import type { ClienteFactura, ClienteFacturaDetalle } from "../types/cliente";

export const getClienteFactura = async () => {
  const res = await api.get<ClienteFactura[]>("/clientes/reporteClienteFactura");
  return res.data;
};

export const getClienteFacturaDetalle = async () => {
  const res = await api.get<ClienteFacturaDetalle[]>("/clientes/reporteClienteFacturaDetalle");
  return res.data;
};
