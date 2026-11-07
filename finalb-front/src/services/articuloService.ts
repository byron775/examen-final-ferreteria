import api from "./api";
import type { Articulo, ArticuloCategoria } from "../types/articulo";

export const getArticulosFiltro = async (nombre: string) => {
  const res = await api.get<Articulo[]>("/articulos/mostrarActivosFiltro", { params: { nombre } });
  return res.data;
};

export const getArticuloCategoria = async () => {
  const res = await api.get<ArticuloCategoria[]>("/articulos/reporteArticuloCategoria");
  return res.data;
};
