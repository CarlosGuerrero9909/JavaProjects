--insert in table tipocontacto
insert into tipocontacto (idtipocon, desctipocon) values ('1', 'Telefono Casa');
insert into tipocontacto (idtipocon, desctipocon) values ('2', 'Celular');
insert into tipocontacto (idtipocon, desctipocon) values ('3', 'Direccion Residencia');
insert into tipocontacto (idtipocon, desctipocon) values ('4', 'Direccion Empresa');
insert into tipocontacto (idtipocon, desctipocon) values ('5', 'Correo Personal');
insert into tipocontacto (idtipocon, desctipocon) values ('6', 'Correo Empresa');

-- insert in table TipoPersona
insert into tipopersona (idtipopersona, desctipopersona) values ('1', 'Cliente');
insert into tipopersona (idtipopersona, desctipopersona) values ('2', 'Proveedor');

-- insert in table TipoIdentificacion
insert into tipoidentificacion (tipoidenti, desctipoidenti) values ('1', 'Cedula');
insert into tipoidentificacion (tipoidenti, desctipoidenti) values ('2', 'Nit');
insert into tipoidentificacion (tipoidenti, desctipoidenti) values ('3', 'TI');
insert into tipoidentificacion (tipoidenti, desctipoidenti) values ('4', 'Cedula Extranjeria');

-- insert in table FormaPago
insert into formapago (idformapago, descformapago) values ('1', 'PSE');
insert into formapago (idformapago, descformapago) values ('2', 'Debito');
insert into formapago (idformapago, descformapago) values ('3', 'Credito');
insert into formapago (idformapago, descformapago) values ('4', 'Efectivo');

-- insert in table TipoFactura
insert into tipofactura (idtipofactura, desctipofactura) values ('1', 'Venta');
insert into tipofactura (idtipofactura, desctipofactura) values ('2', 'Compra');
insert into tipofactura (idtipofactura, desctipofactura) values ('3', 'Devolucion');
insert into tipofactura (idtipofactura, desctipofactura) values ('4', 'Pedido');

-- insert in table TipoDetalle
insert into tipodetalle (idtipodetalle, desctipodetalle) values ('1', 'Ensamble');
insert into tipodetalle (idtipodetalle, desctipodetalle) values ('2', 'Producto');
insert into tipodetalle (idtipodetalle, desctipodetalle) values ('3', 'Revision');
insert into tipodetalle (idtipodetalle, desctipodetalle) values ('4', 'Reparacion');

-- insert in table TipoCargo
insert into tipocargo (idtipocargo, desctipocargo) values ('1', 'Administrador');
insert into tipocargo (idtipocargo, desctipocargo) values ('2', 'Auxiliar');
insert into tipocargo (idtipocargo, desctipocargo) values ('3', 'Tecnico');

-- insert in table TipoElemento
insert into tipoelemento (idtipoelemen, destipoelemen) values ('1', 'Board');
insert into tipoelemento (idtipoelemen, destipoelemen) values ('2', 'Procesador');
insert into tipoelemento (idtipoelemen, destipoelemen) values ('3', 'Ram');
insert into tipoelemento (idtipoelemen, destipoelemen) values ('4', 'Disco Duro');
insert into tipoelemento (idtipoelemen, destipoelemen) values ('5', 'Fnt de Alimentacion');
insert into tipoelemento (idtipoelemen, destipoelemen) values ('6', 'Tarjeta de Red');
insert into tipoelemento (idtipoelemen, destipoelemen) values ('7', 'Tarjeta Grafica');
insert into tipoelemento (idtipoelemen, destipoelemen) values ('8', 'Chasis');
insert into tipoelemento (idtipoelemen, destipoelemen) values ('9', 'Teclado');
insert into tipoelemento (idtipoelemen, destipoelemen) values ('10', 'Monitor');
insert into tipoelemento (idtipoelemen, destipoelemen) values ('11', 'Mouse');
insert into tipoelemento (idtipoelemen, destipoelemen) values ('12', 'Microfono');
insert into tipoelemento (idtipoelemen, destipoelemen) values ('13', 'Auricular');
insert into tipoelemento (idtipoelemen, destipoelemen) values ('14', 'Escaner');
insert into tipoelemento (idtipoelemen, destipoelemen) values ('15', 'Impresora');
insert into tipoelemento (idtipoelemen, destipoelemen) values ('16', 'Parlante');
insert into tipoelemento (idtipoelemen, destipoelemen) values ('17', 'Camara');
insert into tipoelemento (idtipoelemen, destipoelemen) values ('18', 'Concentrador');

-- insert in table TipoCaracteristica
insert into tipocaracteristica (idtipocarac, desctipocarac) values ('1', 'Tecnologia');
insert into tipocaracteristica (idtipocarac, desctipocarac) values ('2', 'Marca');
insert into tipocaracteristica (idtipocarac, desctipocarac) values ('3', 'Velocidad');
insert into tipocaracteristica (idtipocarac, desctipocarac) values ('4', 'Capacidad');
insert into tipocaracteristica (idtipocarac, desctipocarac) values ('5', 'Puerto');
insert into tipocaracteristica (idtipocarac, desctipocarac) values ('6', 'Frecuencia');
insert into tipocaracteristica (idtipocarac, desctipocarac) values ('7', 'Latencia');
insert into tipocaracteristica (idtipocarac, desctipocarac) values ('8', 'Voltaje');
insert into tipocaracteristica (idtipocarac, desctipocarac) values ('9', 'Garantia');
insert into tipocaracteristica (idtipocarac, desctipocarac) values ('10', 'Tiempo Medio Acceso');
insert into tipocaracteristica (idtipocarac, desctipocarac) values ('11', 'Interfaz');
insert into tipocaracteristica (idtipocarac, desctipocarac) values ('12', 'Controlador');

-- insert in table Evento
insert into evento (idevento, descevento) values ('1', 'Compra');
insert into evento (idevento, descevento) values ('2', 'Venta');
insert into evento (idevento, descevento) values ('3', 'Ensamble');
insert into evento (idevento, descevento) values ('4', 'Devolucion');
insert into evento (idevento, descevento) values ('5', 'Descompuesto');
insert into evento (idevento, descevento) values ('6', 'Perdido');

-- insert in table Emplead
-- administrativos
insert into empleado (codempleado, nomempleado, apellempleado, idenempleado, fechaingreso, fechanacimiento, tipoidentifk) values ('1', 'Juan', 'Perez', '12345678', '2015-01-05', '1990-03-01','1');
insert into empleado (codempleado, nomempleado, apellempleado, idenempleado, fechaingreso, fechanacimiento, tipoidentifk) values ('2', 'Rosa', 'Ramirez', '987654', '2012-04-07', '1989-02-21','1');

-- insert in HistoriCargo
insert into historicargo (conseccargo ,codempleadofk, idtipocargofk, fechainicio) values ('1', '1', '1', to_date('2015/01/05', 'yyyy/mm/dd'));
insert into historicargo (conseccargo ,codempleadofk, idtipocargofk, fechainicio) values ('2', '2', '1', to_date('2015/01/05', 'yyyy/mm/dd'));

-- auxiliares
insert into empleado (codempleado, nomempleado, apellempleado, idenempleado, fechaingreso, fechanacimiento, tipoidentifk) values ('3', 'Nairo', 'Naranjo', '7441457', '2019-10-15', '1999-01-11','1');
insert into empleado (codempleado, nomempleado, apellempleado, idenempleado, fechaingreso, fechanacimiento, tipoidentifk) values ('4', 'Andres', 'Diaz', '4354656', '2018-11-22', '1997-04-13','1');
insert into empleado (codempleado, nomempleado, apellempleado, idenempleado, fechaingreso, fechanacimiento, tipoidentifk) values ('5', 'Maria', 'Rodriguez', '4155665', '2020-07-04', '2000-01-11','1');

-- insert in HistoriCargo
insert into historicargo (conseccargo ,codempleadofk, idtipocargofk, fechainicio) values ('3', '3', '2',  to_date('2019/10/15', 'yyyy/mm/dd'));
insert into historicargo (conseccargo ,codempleadofk, idtipocargofk, fechainicio) values ('4', '4', '2',  to_date('2018/11/22', 'yyyy/mm/dd'));
insert into historicargo (conseccargo ,codempleadofk, idtipocargofk, fechainicio) values ('5', '5', '2',  to_date('2020/07/04', 'yyyy/mm/dd'));

-- tecnicos
insert into empleado (codempleado, nomempleado, apellempleado, idenempleado, fechaingreso, fechanacimiento, tipoidentifk) values ('6', 'Ana', 'Dominguez', '3571593', '2017-01-05', '1988-10-21','1');
insert into empleado (codempleado, nomempleado, apellempleado, idenempleado, fechaingreso, fechanacimiento, tipoidentifk) values ('7', 'Carlos', 'Perez', '65432178', '2014-11-05', '1995-01-01','1');
insert into empleado (codempleado, nomempleado, apellempleado, idenempleado, fechaingreso, fechanacimiento, tipoidentifk) values ('8', 'Laura', 'Ramirez', '987654', '2012-04-07', '1989-02-21','1');
insert into empleado (codempleado, nomempleado, apellempleado, idenempleado, fechaingreso, fechanacimiento, tipoidentifk) values ('9', 'Federico', 'Naranjo', '7441457', '2019-10-15', '1999-01-11','1');
insert into empleado (codempleado, nomempleado, apellempleado, idenempleado, fechaingreso, fechanacimiento, tipoidentifk) values ('10', 'Daniel', 'Diaz', '4354656', '2018-11-22', '1997-04-13','1');

-- insert in HistoriCargo
insert into historicargo (conseccargo ,codempleadofk, idtipocargofk, fechainicio) values ('6', '6', '3',  to_date('2017/01/05', 'yyyy/mm/dd'));
insert into historicargo (conseccargo ,codempleadofk, idtipocargofk, fechainicio) values ('7', '7', '3',  to_date('2014/11/05', 'yyyy/mm/dd'));
insert into historicargo (conseccargo ,codempleadofk, idtipocargofk, fechainicio) values ('8', '8', '3',  to_date('2012/04/07', 'yyyy/mm/dd'));
insert into historicargo (conseccargo ,codempleadofk, idtipocargofk, fechainicio) values ('9', '9', '3',  to_date('2019/10/15', 'yyyy/mm/dd'));
insert into historicargo (conseccargo ,codempleadofk, idtipocargofk, fechainicio) values ('10', '10', '3',  to_date('2018/11/22', 'yyyy/mm/dd'));

-- insert in table Persona
insert into persona (idpersona, nompersona, apellpersona, idenpersona, fecharegpersona, idtipopersonafk, tipoidentifk) values ('1', 'Juan', 'Perez', '879465',  to_date('1999/07/18', 'yyyy/mm/dd'),'1','1');
insert into persona (idpersona, nompersona, apellpersona, idenpersona, fecharegpersona, idtipopersonafk, tipoidentifk) values ('2', 'Rosa', 'Ramirez', '65421',  to_date('1989/11/21', 'yyyy/mm/dd'),'1','1');
insert into persona (idpersona, nompersona, apellpersona, idenpersona, fecharegpersona, idtipopersonafk, tipoidentifk) values ('3', 'Nairo', 'Naranjo', '784651',  to_date('1996/01/20', 'yyyy/mm/dd'),'1','1');
insert into persona (idpersona, nompersona, apellpersona, idenpersona, fecharegpersona, idtipopersonafk, tipoidentifk) values ('4', 'Andres', 'Diaz', '1254458',  to_date('1990/05/01', 'yyyy/mm/dd'),'1','1');

-- insert in table ReferenciaElemento   
-- board
insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('1', 'ROG Strix B450-F', '1');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('1', 'ASUSTeK Computer, Inc.', '2', '1');

insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('2', 'PRIME B550M-K', '1');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('2', 'ASUSTeK Computer, Inc.', '2', '2');

insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('3', 'B450M PRO4-F', '1');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('3', 'ASRock Incorporation', '2', '3');

-- Procesador
insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('4', 'I7-7700K', '2');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('4', 'Intel', '2', '4');

insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('5', 'RYZEN 5 5600G', '2');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('5', 'AMD', '2', '5');

insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('6', 'RYZEN 9 5950X', '2');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('6', 'AMD', '2', '6');

-- Ram
insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('7', 'DDR4 3200MHz', '3');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('7', 'Kingston', '2', '7');

insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('8', 'DDR4 8GB 2666 PATRIOT', '3');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('8', 'Patriot Memory', '2', '8');

insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('9', 'DDR4 8GB 3200 PATRIOT', '3');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('9', 'Patriot Memory', '2', '9');

-- Disco Duro
insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('10', 'WD 1TB', '4');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('10', 'Western Digital', '2', '10');

insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('11', 'WD 2TB', '4');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('11', 'Western Digital', '2', '11');

insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('12', 'WD 3TB', '4');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('12', 'Western Digital', '2', '12');

-- Fuente de Alimentacion
insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('13', '600W RIOTORO OEM', '5');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('13', 'Riotoro', '2', '13');

insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('14', '650W P650B 80+ BRONZE', '5');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('14', 'Gigabyte', '2', '14');

insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('15', '450W P450B 80+ BRONZE', '5');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('15', 'Gigabyte', '2', '15');

-- Tarjeta de Red
insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('16', 'PRO 100', '6');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('16', 'Intel', '2', '16');

insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('17', 'PRO 200', '6');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('17', 'Intel', '2', '17');

insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('18', 'PRO 300', '6');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('18', 'Intel', '2', '18');

-- Tarjeta Grafica
insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('19', 'GTX 1080', '7');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('19', 'Nvidia', '2', '19');

insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('20', 'GTX 1080TI', '7');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('20', 'Nvidia', '2', '20');

insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('21', 'GTX 2080TI', '7');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('21', 'Nvidia', '2', '21');

-- Chasis
insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('22', 'H100 TG', '8');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('22', 'Thermaltake', '2', '22');

insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('23', 'H330 TG', '8');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('23', 'Thermaltake', '2', '23');

insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('24', 'V200 TG', '8');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('24', 'Thermaltake', '2', '24');

-- Teclado
insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('25', 'K400', '9');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('25', 'Logitech', '2', '25');

insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('26', 'K500', '9');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('26', 'Logitech', '2', '26');

insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('27', 'K800', '9');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('27', 'Logitech', '2', '27');

-- Monitor
insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('28', '27UM5', '10');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('28', 'LG', '2', '28');

insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('29', '24MP400-B', '10');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('29', 'LG', '2', '29');

insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('30', '29WN600-W', '10');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('30', 'LG', '2', '30');


-- Mouse
insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('31', 'M100', '11');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('31', 'Logitech', '2', '31');

insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('32', 'M200', '11');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('32', 'Logitech', '2', '32');

insert into referenciaelemento (idrefe, obsref, idtipoelemenfk) values ('33', 'M300', '11');
--specs
insert into referenciacaracteristica (itemrefcara, valorrefcara, idtipocaracfk, idrefefk) values ('33', 'Logitech', '2', '33');

-- insert into inventario
--board 1
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('1', to_date('03/06/2020', 'dd/mm/yyyy'), '100000', '1', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('2', to_date('03/06/2020', 'dd/mm/yyyy'), '100000', '1', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('3', to_date('03/06/2020', 'dd/mm/yyyy'), '100000', '1', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('4', to_date('03/06/2020', 'dd/mm/yyyy'), '100000', '1', '1', '1');

--board 2
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('5', to_date('13/02/2021', 'dd/mm/yyyy'), '340000', '2', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('6', to_date('13/02/2021', 'dd/mm/yyyy'), '340000', '2', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('7', to_date('13/02/2021', 'dd/mm/yyyy'), '340000', '2', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('8', to_date('13/02/2021', 'dd/mm/yyyy'), '340000', '2', '1', '1');

--board 3
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('9', to_date('03/01/2022', 'dd/mm/yyyy'), '104000', '3', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('10', to_date('03/01/2022', 'dd/mm/yyyy'), '104000', '3', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('11', to_date('03/01/2022', 'dd/mm/yyyy'), '104000', '3', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('12', to_date('03/01/2022', 'dd/mm/yyyy'), '104000', '3', '1', '1');

--procesador 1
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('13', to_date('23/03/2020', 'dd/mm/yyyy'), '450000', '4', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('14', to_date('23/03/2020', 'dd/mm/yyyy'), '450000', '4', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('15', to_date('23/03/2020', 'dd/mm/yyyy'), '450000', '4', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('16', to_date('23/03/2020', 'dd/mm/yyyy'), '450000', '4', '1', '1');

--procesador 2
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('17', to_date('09/01/2022', 'dd/mm/yyyy'), '700000', '5', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('18', to_date('09/01/2022', 'dd/mm/yyyy'), '700000', '5', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('19', to_date('09/01/2022', 'dd/mm/yyyy'), '700000', '5', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('20', to_date('09/01/2022', 'dd/mm/yyyy'), '700000', '5', '1', '1');

--procesador 3
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('21', to_date('15/11/2020', 'dd/mm/yyyy'), '105000', '6', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('22', to_date('15/11/2020', 'dd/mm/yyyy'), '105000', '6', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('23', to_date('15/11/2020', 'dd/mm/yyyy'), '105000', '6', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('24', to_date('15/11/2020', 'dd/mm/yyyy'), '105000', '6', '1', '1');

--ram 1
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('25', to_date('23/12/2021', 'dd/mm/yyyy'), '210000', '7', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('26', to_date('23/12/2021', 'dd/mm/yyyy'), '210000', '7', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('27', to_date('23/12/2021', 'dd/mm/yyyy'), '210000', '7', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('28', to_date('23/12/2021', 'dd/mm/yyyy'), '210000', '7', '1', '1');

--ram 2
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('29', to_date('07/03/2019', 'dd/mm/yyyy'), '400000', '8', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('30', to_date('07/03/2019', 'dd/mm/yyyy'), '400000', '8', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('31', to_date('07/03/2019', 'dd/mm/yyyy'), '400000', '8', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('32', to_date('07/03/2019', 'dd/mm/yyyy'), '500000', '8', '1', '1');

--ram 3
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('33', to_date('01/02/2020', 'dd/mm/yyyy'), '750000', '9', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('34', to_date('01/02/2020', 'dd/mm/yyyy'), '750000', '9', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('35', to_date('01/02/2020', 'dd/mm/yyyy'), '750000', '9', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('36', to_date('01/02/2020', 'dd/mm/yyyy'), '750000', '9', '1', '1');

--discoduro 1
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('37', to_date('08/02/2020', 'dd/mm/yyyy'), '100000', '10', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('38', to_date('08/02/2020', 'dd/mm/yyyy'), '100000', '10', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('39', to_date('08/02/2020', 'dd/mm/yyyy'), '100000', '10', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('40', to_date('08/02/2020', 'dd/mm/yyyy'), '100000', '10', '1', '1');

--discoduro 2
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('41', to_date('30/12/2020', 'dd/mm/yyyy'), '200000', '11', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('42', to_date('30/12/2020', 'dd/mm/yyyy'), '200000', '11', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('43', to_date('30/12/2020', 'dd/mm/yyyy'), '200000', '11', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('44', to_date('30/12/2020', 'dd/mm/yyyy'), '200000', '11', '1', '1');

--discoduro 3
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('45', to_date('13/03/2020', 'dd/mm/yyyy'), '460000', '12', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('46', to_date('13/03/2020', 'dd/mm/yyyy'), '460000', '12', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('47', to_date('13/03/2020', 'dd/mm/yyyy'), '460000', '12', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('48', to_date('13/03/2020', 'dd/mm/yyyy'), '460000', '12', '1', '1');


--fuente de alimentacion 1
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('49', to_date('03/05/2020', 'dd/mm/yyyy'), '155000', '13', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('50', to_date('03/05/2020', 'dd/mm/yyyy'), '155000', '13', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('51', to_date('03/05/2020', 'dd/mm/yyyy'), '155000', '13', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('52', to_date('03/05/2020', 'dd/mm/yyyy'), '155000', '13', '1', '1');

--fuente de alimentacion 2
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('53', to_date('03/04/2021', 'dd/mm/yyyy'), '370000', '14', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('54', to_date('03/04/2021', 'dd/mm/yyyy'), '370000', '14', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('55', to_date('03/04/2021', 'dd/mm/yyyy'), '370000', '14', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('56', to_date('03/04/2021', 'dd/mm/yyyy'), '370000', '14', '1', '1');

--fuente de alimentacion 3
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('57', to_date('15/03/2020', 'dd/mm/yyyy'), '720000', '15', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('58', to_date('15/03/2020', 'dd/mm/yyyy'), '720000', '15', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('59', to_date('15/03/2020', 'dd/mm/yyyy'), '720000', '15', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('60', to_date('15/03/2020', 'dd/mm/yyyy'), '720000', '15', '1', '1');

--targeta de red 1
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('61', to_date('01/01/2022', 'dd/mm/yyyy'), '300000', '16', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('62', to_date('01/01/2022', 'dd/mm/yyyy'), '300000', '16', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('63', to_date('01/01/2022', 'dd/mm/yyyy'), '300000', '16', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('64', to_date('01/01/2022', 'dd/mm/yyyy'), '300000', '16', '1', '1');

--targeta de red 2
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('65', to_date('24/02/2020', 'dd/mm/yyyy'), '245000', '17', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('66', to_date('24/02/2020', 'dd/mm/yyyy'), '245000', '17', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('67', to_date('24/02/2020', 'dd/mm/yyyy'), '245000', '17', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('68', to_date('24/02/2020', 'dd/mm/yyyy'), '245000', '17', '1', '1');

--targeta de red 3
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('69', to_date('22/03/2021', 'dd/mm/yyyy'), '330000', '18', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('70', to_date('22/03/2021', 'dd/mm/yyyy'), '330000', '18', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('71', to_date('22/03/2021', 'dd/mm/yyyy'), '330000', '18', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('72', to_date('22/03/2021', 'dd/mm/yyyy'), '330000', '18', '1', '1');

--targeta grafica 1
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('73', to_date('05/05/2020', 'dd/mm/yyyy'), '550000', '19', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('74', to_date('05/05/2020', 'dd/mm/yyyy'), '550000', '19', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('75', to_date('05/05/2020', 'dd/mm/yyyy'), '550000', '19', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('76', to_date('05/05/2020', 'dd/mm/yyyy'), '550000', '19', '1', '1');

--targeta grafica 2
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('77', to_date('13/02/2020', 'dd/mm/yyyy'), '320000', '20', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('78', to_date('13/02/2020', 'dd/mm/yyyy'), '320000', '20', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('79', to_date('13/02/2020', 'dd/mm/yyyy'), '320000', '20', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('80', to_date('13/02/2020', 'dd/mm/yyyy'), '320000', '20', '1', '1');

--targeta grafica 3
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('81', to_date('26/04/2020', 'dd/mm/yyyy'), '650000', '21', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('82', to_date('26/04/2020', 'dd/mm/yyyy'), '650000', '21', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('83', to_date('26/04/2020', 'dd/mm/yyyy'), '650000', '21', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('84', to_date('26/04/2020', 'dd/mm/yyyy'), '650000', '21', '1', '1');

--chasis 1
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('85', to_date('17/07/2020', 'dd/mm/yyyy'), '670000', '22', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('86', to_date('17/07/2020', 'dd/mm/yyyy'), '670000', '22', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('87', to_date('17/07/2020', 'dd/mm/yyyy'), '670000', '22', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('88', to_date('17/07/2020', 'dd/mm/yyyy'), '670000', '22', '1', '1');

--chasis 2
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('89', to_date('11/03/2021', 'dd/mm/yyyy'), '730000', '23', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('90', to_date('11/03/2021', 'dd/mm/yyyy'), '730000', '23', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('91', to_date('11/03/2021', 'dd/mm/yyyy'), '730000', '23', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('92', to_date('11/03/2021', 'dd/mm/yyyy'), '730000', '23', '1', '1');

--chasis 3
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('93', to_date('23/01/2022', 'dd/mm/yyyy'), '460000', '24', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('94', to_date('23/01/2022', 'dd/mm/yyyy'), '460000', '24', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('95', to_date('23/01/2022', 'dd/mm/yyyy'), '460000', '24', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('96', to_date('23/01/2022', 'dd/mm/yyyy'), '460000', '24', '1', '1');

--teclado 1
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('97', to_date('06/07/2020', 'dd/mm/yyyy'), '100000', '25', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('98', to_date('06/07/2020', 'dd/mm/yyyy'), '100000', '25', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('99', to_date('06/07/2020', 'dd/mm/yyyy'), '100000', '25', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('100', to_date('06/07/2020', 'dd/mm/yyyy'), '100000', '25', '1', '1');

--teclado 2
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('101', to_date('19/05/2021', 'dd/mm/yyyy'), '107000', '26', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('102', to_date('19/05/2021', 'dd/mm/yyyy'), '107000', '26', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('103', to_date('19/05/2021', 'dd/mm/yyyy'), '107000', '26', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('104', to_date('19/05/2021', 'dd/mm/yyyy'), '107000', '26', '1', '1');

--teclado 3
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('105', to_date('23/02/2020', 'dd/mm/yyyy'), '340000', '27', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('106', to_date('23/02/2020', 'dd/mm/yyyy'), '340000', '27', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('107', to_date('23/02/2020', 'dd/mm/yyyy'), '340000', '27', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('108', to_date('23/02/2020', 'dd/mm/yyyy'), '340000', '27', '1', '1');

--monitor 1
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('109', to_date('22/11/2020', 'dd/mm/yyyy'), '675000', '28', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('110', to_date('22/11/2020', 'dd/mm/yyyy'), '675000', '28', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('111', to_date('22/11/2020', 'dd/mm/yyyy'), '675000', '28', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('112', to_date('22/11/2020', 'dd/mm/yyyy'), '675000', '28', '1', '1');

--monitor 2
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('113', to_date('23/04/2021', 'dd/mm/yyyy'), '660000', '29', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('114', to_date('23/04/2021', 'dd/mm/yyyy'), '660000', '29', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('115', to_date('23/04/2021', 'dd/mm/yyyy'), '660000', '29', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('116', to_date('23/04/2021', 'dd/mm/yyyy'), '660000', '29', '1', '1');

--monitor 3
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('117', to_date('05/06/2022', 'dd/mm/yyyy'), '900000', '30', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('118', to_date('05/06/2022', 'dd/mm/yyyy'), '900000', '30', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('119', to_date('05/06/2022', 'dd/mm/yyyy'), '900000', '30', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('120', to_date('05/06/2022', 'dd/mm/yyyy'), '900000', '30', '1', '1');

--mouse 1
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('121', to_date('12/12/2020', 'dd/mm/yyyy'), '740000', '31', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('122', to_date('12/12/2020', 'dd/mm/yyyy'), '740000', '31', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('123', to_date('12/12/2020', 'dd/mm/yyyy'), '740000', '31', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('124', to_date('12/12/2020', 'dd/mm/yyyy'), '740000', '31', '1', '1');

--mouse 2
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('125', to_date('27/05/2020', 'dd/mm/yyyy'), '200000', '32', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('126', to_date('27/05/2020', 'dd/mm/yyyy'), '200000', '32', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('127', to_date('27/05/2020', 'dd/mm/yyyy'), '200000', '32', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('128', to_date('27/05/2020', 'dd/mm/yyyy'), '200000', '32', '1', '1');

--mouse 3
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('129', to_date('14/05/2020', 'dd/mm/yyyy'), '120000', '33', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('130', to_date('14/05/2020', 'dd/mm/yyyy'), '120000', '33', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('131', to_date('14/05/2020', 'dd/mm/yyyy'), '120000', '33', '1', '1');
insert into inventario (noinventario, fechaevento, valor, idrefefk, codempleadofk, ideventofk) values ('132', to_date('14/05/2020', 'dd/mm/yyyy'), '120000', '33', '1', '1');

--insert into ensable
--facturado true
insert into ensamble (consecc, fechaensamble, facturado, codempleadofk) values ('1', to_date('12/12/2021', 'dd/mm/yyyy'), 'true', '1');

--facturado false
insert into ensamble (consecc, fechaensamble, facturado, codempleadofk) values ('2', to_date('15/07/2020', 'dd/mm/yyyy'), 'false', '1');
insert into ensamble (consecc, fechaensamble, facturado, codempleadofk) values ('3', to_date('16/02/2021', 'dd/mm/yyyy'), 'false', '1');

--insert into detalleensamble
--ensamble 1
insert into detalleensamble (itemensamble, conseccfk, noinventariofk, idrefefk) values ('1', '1', '1', '1');
-- update inventario, evento
update inventario set ideventofk = '3' where noinventario = '1' and idrefefk = '1';

insert into detalleensamble (itemensamble, conseccfk, noinventariofk, idrefefk) values ('2', '1', '13', '4');
-- update inventario, evento
update inventario set ideventofk = '3' where noinventario = '13' and idrefefk = '4';

insert into detalleensamble (itemensamble, conseccfk, noinventariofk, idrefefk) values ('3', '1', '25', '7');
-- update inventario, evento
update inventario set ideventofk = '3' where noinventario = '25' and idrefefk = '7';

insert into detalleensamble (itemensamble, conseccfk, noinventariofk, idrefefk) values ('4', '1', '37', '10');
-- update inventario, evento
update inventario set ideventofk = '3' where noinventario = '37' and idrefefk = '10';

insert into detalleensamble (itemensamble, conseccfk, noinventariofk, idrefefk) values ('5', '1', '49', '13');
-- update inventario, evento
update inventario set ideventofk = '3' where noinventario = '49' and idrefefk = '13';

insert into detalleensamble (itemensamble, conseccfk, noinventariofk, idrefefk) values ('6', '1', '61', '16');
-- update inventario, evento
update inventario set ideventofk = '3' where noinventario = '61' and idrefefk = '16';


--ensamble 2
insert into detalleensamble (itemensamble, conseccfk, noinventariofk, idrefefk) values ('7', '2', '5', '2');
-- update inventario, evento
update inventario set ideventofk = '3' where noinventario = '2' and idrefefk = '1';

insert into detalleensamble (itemensamble, conseccfk, noinventariofk, idrefefk) values ('8', '2', '17', '5');
-- update inventario, evento
update inventario set ideventofk = '3' where noinventario = '14' and idrefefk = '4';

insert into detalleensamble (itemensamble, conseccfk, noinventariofk, idrefefk) values ('9', '2', '29', '8');
-- update inventario, evento
update inventario set ideventofk = '3' where noinventario = '26' and idrefefk = '7';

insert into detalleensamble (itemensamble, conseccfk, noinventariofk, idrefefk) values ('10', '2', '41', '11');
-- update inventario, evento
update inventario set ideventofk = '3' where noinventario = '38' and idrefefk = '10';

insert into detalleensamble (itemensamble, conseccfk, noinventariofk, idrefefk) values ('11', '2', '53', '14');
-- update inventario, evento
update inventario set ideventofk = '3' where noinventario = '50' and idrefefk = '13';

insert into detalleensamble (itemensamble, conseccfk, noinventariofk, idrefefk) values ('12', '2', '65', '17');
-- update inventario, evento
update inventario set ideventofk = '3' where noinventario = '62' and idrefefk = '16';


--ensamble 3
insert into detalleensamble (itemensamble, conseccfk, noinventariofk, idrefefk) values ('13', '3', '9', '3');
-- update inventario, evento
update inventario set ideventofk = '3' where noinventario = '3' and idrefefk = '1';

insert into detalleensamble (itemensamble, conseccfk, noinventariofk, idrefefk) values ('14', '3', '21', '6');
-- update inventario, evento
update inventario set ideventofk = '3' where noinventario = '15' and idrefefk = '4';

insert into detalleensamble (itemensamble, conseccfk, noinventariofk, idrefefk) values ('15', '3', '33', '9');
-- update inventario, evento
update inventario set ideventofk = '3' where noinventario = '27' and idrefefk = '7';

insert into detalleensamble (itemensamble, conseccfk, noinventariofk, idrefefk) values ('16', '3', '45', '12');
-- update inventario, evento
update inventario set ideventofk = '3' where noinventario = '39' and idrefefk = '10';

insert into detalleensamble (itemensamble, conseccfk, noinventariofk, idrefefk) values ('17', '3', '57', '15');
-- update inventario, evento
update inventario set ideventofk = '3' where noinventario = '51' and idrefefk = '13';

insert into detalleensamble (itemensamble, conseccfk, noinventariofk, idrefefk) values ('18', '3', '69', '18');
-- update inventario, evento
update inventario set ideventofk = '3' where noinventario = '63' and idrefefk = '16';



/*/------------------------*/


/*NICEEEEEEEEEEEEEEEEEEEE HASTA ACA*/


/*------------------------*/
