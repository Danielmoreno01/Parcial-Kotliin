<?php

	const APP_URL="http://localhost/VENTAS/";
	const APP_NAME="Inventario y Venta Electrodom ";
	const APP_SESSION_NAME="POS";

	/*Tipos Documentos*/
	const DOCUMENTOS_USUARIOS=["DUI","DNI","Cedula","Licencia","Pasaporte","Otro"];


	/*Unidades*/
	const PRODUCTO_UNIDAD=["Unidad","Libra","Kilogramo","Caja","Paquete","Lata","Galon","Botella","Tira","Sobre","Bolsa","Saco","Tarjeta","Otro"];

	/*Configuración de moneda*/
	const MONEDA_SIMBOLO="$";
	const MONEDA_NOMBRE="COP";
	const MONEDA_DECIMALES="2";
	const MONEDA_SEPARADOR_MILLAR=",";
	const MONEDA_SEPARADOR_DECIMAL=".";


    /*Marcador de campos obligatorios*/
	const CAMPO_OBLIGATORIO='&nbsp; <i class="fas fa-edit"></i> &nbsp;';

	/*Zona horaria sistema*/
	date_default_timezone_set("America/Bogota");

