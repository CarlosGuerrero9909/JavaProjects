/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     07/08/2022 03:38:57 p. m.                    */
/*==============================================================*/


/*==============================================================*/
/* Table: CONTACTO                                              */
/*==============================================================*/
create table CONTACTO (
   CONSECCONTACTO       INT4                 not null,
   IDTIPOPERSONAFK      VARCHAR(2)           not null,
   IDPERSONAFK          VARCHAR(3)           not null,
   IDTIPOCONFK          VARCHAR(2)           not null,
   VALORCONTACTO        VARCHAR(40)          not null,
   OBSERVACION          VARCHAR(50)          null,
   constraint PK_CONTACTO primary key (IDTIPOPERSONAFK, IDPERSONAFK, CONSECCONTACTO)
);

/*==============================================================*/
/* Index: CONTACTO_PK                                           */
/*==============================================================*/
create unique index CONTACTO_PK on CONTACTO (
IDTIPOPERSONAFK,
IDPERSONAFK,
CONSECCONTACTO
);

/*==============================================================*/
/* Index: TIPOCONTACTO_CONTACTO_FK                              */
/*==============================================================*/
create  index TIPOCONTACTO_CONTACTO_FK on CONTACTO (
IDTIPOCONFK
);

/*==============================================================*/
/* Index: CONTACTO_PERSONA_FK                                   */
/*==============================================================*/
create  index CONTACTO_PERSONA_FK on CONTACTO (
IDTIPOPERSONAFK,
IDPERSONAFK
);

/*==============================================================*/
/* Table: DETALLEENSAMBLE                                       */
/*==============================================================*/
create table DETALLEENSAMBLE (
   ITEMENSAMBLE         INT4                 not null,
   CONSECCFK            INT4                 not null,
   IDREFEFK             INT4                 not null,
   NOINVENTARIOFK       INT4                 not null,
   constraint PK_DETALLEENSAMBLE primary key (IDREFEFK, NOINVENTARIOFK, CONSECCFK, ITEMENSAMBLE)
);

/*==============================================================*/
/* Index: DETALLEENSAMBLE_PK                                    */
/*==============================================================*/
create unique index DETALLEENSAMBLE_PK on DETALLEENSAMBLE (
IDREFEFK,
NOINVENTARIOFK,
CONSECCFK,
ITEMENSAMBLE
);

/*==============================================================*/
/* Index: ENSAMBLE_DETALLEENSAMBLE_FK                           */
/*==============================================================*/
create  index ENSAMBLE_DETALLEENSAMBLE_FK on DETALLEENSAMBLE (
CONSECCFK
);

/*==============================================================*/
/* Index: DETALLEENSAMBLE_INVENTARIO_FK                         */
/*==============================================================*/
create  index DETALLEENSAMBLE_INVENTARIO_FK on DETALLEENSAMBLE (
IDREFEFK,
NOINVENTARIOFK
);

/*==============================================================*/
/* Table: DETALLEFACTURA                                        */
/*==============================================================*/
create table DETALLEFACTURA (
   ITEM                 INT4                 not null,
   NFACTURAFK           INT4                 not null,
   IDTIPODETALLEFK      VARCHAR(2)           not null,
   CONSECCFK            INT4                 null,
   IDREFEFK             INT4                 null,
   NOINVENTARIOFK       INT4                 null,
   CANTIDAD             INT4                 not null,
   PRECIO               NUMERIC(11,2)        not null,
   constraint PK_DETALLEFACTURA primary key (NFACTURAFK, ITEM)
);

/*==============================================================*/
/* Index: DETALLEFACTURA_PK                                     */
/*==============================================================*/
create unique index DETALLEFACTURA_PK on DETALLEFACTURA (
NFACTURAFK,
ITEM
);

/*==============================================================*/
/* Index: FACTURA_DETALLEFACTURA_FK                             */
/*==============================================================*/
create  index FACTURA_DETALLEFACTURA_FK on DETALLEFACTURA (
NFACTURAFK
);

/*==============================================================*/
/* Index: TIPODETALLE_DETALLEFACTURA_FK                         */
/*==============================================================*/
create  index TIPODETALLE_DETALLEFACTURA_FK on DETALLEFACTURA (
IDTIPODETALLEFK
);

/*==============================================================*/
/* Index: DETALLEFACTURA_ENSAMBLE_FK                            */
/*==============================================================*/
create  index DETALLEFACTURA_ENSAMBLE_FK on DETALLEFACTURA (
CONSECCFK
);

/*==============================================================*/
/* Index: DETALLEFACTURA_INVENTARIO_FK                          */
/*==============================================================*/
create  index DETALLEFACTURA_INVENTARIO_FK on DETALLEFACTURA (
IDREFEFK,
NOINVENTARIOFK
);

/*==============================================================*/
/* Table: EMPLEADO                                              */
/*==============================================================*/
create table EMPLEADO (
   CODEMPLEADO          VARCHAR(3)           not null,
   TIPOIDENTIFK         VARCHAR(2)           not null,
   NOMEMPLEADO          VARCHAR(30)          not null,
   APELLEMPLEADO        VARCHAR(30)          not null,
   IDENEMPLEADO         VARCHAR(15)          not null,
   FECHAINGRESO         DATE                 not null,
   FECHANACIMIENTO      DATE                 not null,
   constraint PK_EMPLEADO primary key (CODEMPLEADO)
);

/*==============================================================*/
/* Index: EMPLEADO_PK                                           */
/*==============================================================*/
create unique index EMPLEADO_PK on EMPLEADO (
CODEMPLEADO
);

/*==============================================================*/
/* Index: TIPOIDENTIFICACION_EMPLEADO_FK                        */
/*==============================================================*/
create  index TIPOIDENTIFICACION_EMPLEADO_FK on EMPLEADO (
TIPOIDENTIFK
);

/*==============================================================*/
/* Table: ENSAMBLE                                              */
/*==============================================================*/
create table ENSAMBLE (
   CONSECC              INT4                 not null,
   CODEMPLEADOFK        VARCHAR(3)           null,
   FECHAENSAMBLE        DATE                 not null,
   FACTURADO            BOOL                 not null,
   constraint PK_ENSAMBLE primary key (CONSECC)
);

/*==============================================================*/
/* Index: ENSAMBLE_PK                                           */
/*==============================================================*/
create unique index ENSAMBLE_PK on ENSAMBLE (
CONSECC
);

/*==============================================================*/
/* Index: EMPLEADO_ENSAMBLE_FK                                  */
/*==============================================================*/
create  index EMPLEADO_ENSAMBLE_FK on ENSAMBLE (
CODEMPLEADOFK
);

/*==============================================================*/
/* Table: EVENTO                                                */
/*==============================================================*/
create table EVENTO (
   IDEVENTO             VARCHAR(2)           not null,
   DESCEVENTO           VARCHAR(20)          not null,
   constraint PK_EVENTO primary key (IDEVENTO)
);

/*==============================================================*/
/* Index: EVENTO_PK                                             */
/*==============================================================*/
create unique index EVENTO_PK on EVENTO (
IDEVENTO
);

/*==============================================================*/
/* Table: FACTURA                                               */
/*==============================================================*/
create table FACTURA (
   NFACTURA             INT4                 not null,
   IDFORMAPAGOFK        VARCHAR(2)           not null,
   IDTIPOPERSONAFK      VARCHAR(2)           not null,
   IDPERSONAFK          VARCHAR(3)           not null,
   IDTIPOFACTURAFK      VARCHAR(2)           not null,
   CODEMPLEADOFK        VARCHAR(3)           not null,
   FECHAFACTURA         DATE                 not null,
   VALORFACTURA         NUMERIC(110,11)        null,
   constraint PK_FACTURA primary key (NFACTURA)
);

/*==============================================================*/
/* Index: FACTURA_PK                                            */
/*==============================================================*/
create unique index FACTURA_PK on FACTURA (
NFACTURA
);

/*==============================================================*/
/* Index: FORMAPAGO_FACTURA_FK                                  */
/*==============================================================*/
create  index FORMAPAGO_FACTURA_FK on FACTURA (
IDFORMAPAGOFK
);

/*==============================================================*/
/* Index: PERSONA_FACTURA_FK                                    */
/*==============================================================*/
create  index PERSONA_FACTURA_FK on FACTURA (
IDTIPOPERSONAFK,
IDPERSONAFK
);

/*==============================================================*/
/* Index: TIPOFACTURA_FACTURA_FK                                */
/*==============================================================*/
create  index TIPOFACTURA_FACTURA_FK on FACTURA (
IDTIPOFACTURAFK
);

/*==============================================================*/
/* Index: FACTURA_EMPLEADO_FK                                   */
/*==============================================================*/
create  index FACTURA_EMPLEADO_FK on FACTURA (
CODEMPLEADOFK
);

/*==============================================================*/
/* Table: FORMAPAGO                                             */
/*==============================================================*/
create table FORMAPAGO (
   IDFORMAPAGO          VARCHAR(2)           not null,
   DESCFORMAPAGO        VARCHAR(20)          not null,
   constraint PK_FORMAPAGO primary key (IDFORMAPAGO)
);

/*==============================================================*/
/* Index: FORMAPAGO_PK                                          */
/*==============================================================*/
create unique index FORMAPAGO_PK on FORMAPAGO (
IDFORMAPAGO
);

/*==============================================================*/
/* Table: HISTORICARGO                                          */
/*==============================================================*/
create table HISTORICARGO (
   CONSECCARGO          INT4                 not null,
   IDTIPOCARGOFK        VARCHAR(2)           not null,
   CODEMPLEADOFK        VARCHAR(3)           not null,
   FECHAINICIO          DATE                 not null,
   FECHAFIN             DATE                 null,
   constraint PK_HISTORICARGO primary key (CONSECCARGO)
);

/*==============================================================*/
/* Index: HISTORICARGO_PK                                       */
/*==============================================================*/
create unique index HISTORICARGO_PK on HISTORICARGO (
CONSECCARGO
);

/*==============================================================*/
/* Index: HISTORICARGO_EMPLEADO_FK                              */
/*==============================================================*/
create  index HISTORICARGO_EMPLEADO_FK on HISTORICARGO (
CODEMPLEADOFK
);

/*==============================================================*/
/* Index: TIPOCARGO_HISTORICARGO_FK                             */
/*==============================================================*/
create  index TIPOCARGO_HISTORICARGO_FK on HISTORICARGO (
IDTIPOCARGOFK
);

/*==============================================================*/
/* Table: INVENTARIO                                            */
/*==============================================================*/
create table INVENTARIO (
   NOINVENTARIO         INT4                 not null,
   IDREFEFK             INT4                 not null,
   CODEMPLEADOFK        VARCHAR(3)           not null,
   NFACTURAFK           INT4                 null,
   IDEVENTOFK           VARCHAR(2)           not null,
   FECHAEVENTO          DATE                 not null,
   VALOR                NUMERIC(11,2)        not null,
   constraint PK_INVENTARIO primary key (IDREFEFK, NOINVENTARIO)
);

/*==============================================================*/
/* Index: INVENTARIO_PK                                         */
/*==============================================================*/
create unique index INVENTARIO_PK on INVENTARIO (
IDREFEFK,
NOINVENTARIO
);

/*==============================================================*/
/* Index: INVENTARIO_EVENTO_FK                                  */
/*==============================================================*/
create  index INVENTARIO_EVENTO_FK on INVENTARIO (
IDEVENTOFK
);

/*==============================================================*/
/* Index: INVENTARIO_REFELEMENTO_FK                             */
/*==============================================================*/
create  index INVENTARIO_REFELEMENTO_FK on INVENTARIO (
IDREFEFK
);

/*==============================================================*/
/* Index: EMPLEADO_INVENTARIO_FK                                */
/*==============================================================*/
create  index EMPLEADO_INVENTARIO_FK on INVENTARIO (
CODEMPLEADOFK
);

/*==============================================================*/
/* Index: FACTURA_INVENTARIO_FK                                 */
/*==============================================================*/
create  index FACTURA_INVENTARIO_FK on INVENTARIO (
NFACTURAFK
);

/*==============================================================*/
/* Table: PERSONA                                               */
/*==============================================================*/
create table PERSONA (
   IDPERSONA            VARCHAR(3)           not null,
   IDTIPOPERSONAFK      VARCHAR(2)           not null,
   TIPOIDENTIFK         VARCHAR(2)           not null,
   NOMPERSONA           VARCHAR(30)          not null,
   APELLPERSONA         VARCHAR(30)          null,
   FECHAREGPERSONA      DATE                 not null,
   IDENPERSONA          VARCHAR(15)          not null,
   constraint PK_PERSONA primary key (IDTIPOPERSONAFK, IDPERSONA)
);

/*==============================================================*/
/* Index: PERSONA_PK                                            */
/*==============================================================*/
create unique index PERSONA_PK on PERSONA (
IDTIPOPERSONAFK,
IDPERSONA
);

/*==============================================================*/
/* Index: TIPOPERSONA_PERSONA_FK                                */
/*==============================================================*/
create  index TIPOPERSONA_PERSONA_FK on PERSONA (
IDTIPOPERSONAFK
);

/*==============================================================*/
/* Index: TIPOIDENTIFICACION_PERSONA_FK                         */
/*==============================================================*/
create  index TIPOIDENTIFICACION_PERSONA_FK on PERSONA (
TIPOIDENTIFK
);

/*==============================================================*/
/* Table: REFERENCIACARACTERISTICA                              */
/*==============================================================*/
create table REFERENCIACARACTERISTICA (
   IDREFEFK             INT4                 not null,
   ITEMREFCARA          INT4                 not null,
   IDUNIDADFK           VARCHAR(2)           null,
   IDTIPOCARACFK        VARCHAR(4)           not null,
   VALORREFCARA         VARCHAR(30)          not null,
   constraint PK_REFERENCIACARACTERISTICA primary key (IDREFEFK, ITEMREFCARA)
);

/*==============================================================*/
/* Index: REFERENCIACARACTERISTICA_PK                           */
/*==============================================================*/
create unique index REFERENCIACARACTERISTICA_PK on REFERENCIACARACTERISTICA (
IDREFEFK,
ITEMREFCARA
);

/*==============================================================*/
/* Index: UMEDIDA_REFCARACTERISTICA_FK                          */
/*==============================================================*/
create  index UMEDIDA_REFCARACTERISTICA_FK on REFERENCIACARACTERISTICA (
IDUNIDADFK
);

/*==============================================================*/
/* Index: TIPOCARACT_REFCARACT_FK                               */
/*==============================================================*/
create  index TIPOCARACT_REFCARACT_FK on REFERENCIACARACTERISTICA (
IDTIPOCARACFK
);

/*==============================================================*/
/* Index: REFELEMENTO_REFCARAC_FK                               */
/*==============================================================*/
create  index REFELEMENTO_REFCARAC_FK on REFERENCIACARACTERISTICA (
IDREFEFK
);

/*==============================================================*/
/* Table: REFERENCIAELEMENTO                                    */
/*==============================================================*/
create table REFERENCIAELEMENTO (
   IDREFE               INT4                 not null,
   IDTIPOELEMENFK       VARCHAR(2)           not null,
   OBSREF               VARCHAR(50)          not null,
   constraint PK_REFERENCIAELEMENTO primary key (IDREFE)
);

/*==============================================================*/
/* Index: REFERENCIAELEMENTO_PK                                 */
/*==============================================================*/
create unique index REFERENCIAELEMENTO_PK on REFERENCIAELEMENTO (
IDREFE
);

/*==============================================================*/
/* Index: TIPOELEMENTO_REFELEMENTO_FK                           */
/*==============================================================*/
create  index TIPOELEMENTO_REFELEMENTO_FK on REFERENCIAELEMENTO (
IDTIPOELEMENFK
);

/*==============================================================*/
/* Table: TIPOCARACTERISTICA                                    */
/*==============================================================*/
create table TIPOCARACTERISTICA (
   IDTIPOCARAC          VARCHAR(4)           not null,
   DESCTIPOCARAC        VARCHAR(30)          not null,
   constraint PK_TIPOCARACTERISTICA primary key (IDTIPOCARAC)
);

/*==============================================================*/
/* Index: TIPOCARACTERISTICA_PK                                 */
/*==============================================================*/
create unique index TIPOCARACTERISTICA_PK on TIPOCARACTERISTICA (
IDTIPOCARAC
);

/*==============================================================*/
/* Table: TIPOCARGO                                             */
/*==============================================================*/
create table TIPOCARGO (
   IDTIPOCARGO          VARCHAR(2)           not null,
   DESCTIPOCARGO        VARCHAR(20)          not null,
   constraint PK_TIPOCARGO primary key (IDTIPOCARGO)
);

/*==============================================================*/
/* Index: TIPOCARGO_PK                                          */
/*==============================================================*/
create unique index TIPOCARGO_PK on TIPOCARGO (
IDTIPOCARGO
);

/*==============================================================*/
/* Table: TIPOCONTACTO                                          */
/*==============================================================*/
create table TIPOCONTACTO (
   IDTIPOCON            VARCHAR(2)           not null,
   DESCTIPOCON          VARCHAR(20)          not null,
   constraint PK_TIPOCONTACTO primary key (IDTIPOCON)
);

/*==============================================================*/
/* Index: TIPOCONTACTO_PK                                       */
/*==============================================================*/
create unique index TIPOCONTACTO_PK on TIPOCONTACTO (
IDTIPOCON
);

/*==============================================================*/
/* Table: TIPODETALLE                                           */
/*==============================================================*/
create table TIPODETALLE (
   IDTIPODETALLE        VARCHAR(2)           not null,
   DESCTIPODETALLE      VARCHAR(20)          not null,
   constraint PK_TIPODETALLE primary key (IDTIPODETALLE)
);

/*==============================================================*/
/* Index: TIPODETALLE_PK                                        */
/*==============================================================*/
create unique index TIPODETALLE_PK on TIPODETALLE (
IDTIPODETALLE
);

/*==============================================================*/
/* Table: TIPOELEMENTO                                          */
/*==============================================================*/
create table TIPOELEMENTO (
   IDTIPOELEMEN         VARCHAR(2)           not null,
   DESTIPOELEMEN        VARCHAR(20)          not null,
   constraint PK_TIPOELEMENTO primary key (IDTIPOELEMEN)
);

/*==============================================================*/
/* Index: TIPOELEMENTO_PK                                       */
/*==============================================================*/
create unique index TIPOELEMENTO_PK on TIPOELEMENTO (
IDTIPOELEMEN
);

/*==============================================================*/
/* Table: TIPOFACTURA                                           */
/*==============================================================*/
create table TIPOFACTURA (
   IDTIPOFACTURA        VARCHAR(2)           not null,
   DESCTIPOFACTURA      VARCHAR(20)          not null,
   constraint PK_TIPOFACTURA primary key (IDTIPOFACTURA)
);

/*==============================================================*/
/* Index: TIPOFACTURA_PK                                        */
/*==============================================================*/
create unique index TIPOFACTURA_PK on TIPOFACTURA (
IDTIPOFACTURA
);

/*==============================================================*/
/* Table: TIPOIDENTIFICACION                                    */
/*==============================================================*/
create table TIPOIDENTIFICACION (
   TIPOIDENTI           VARCHAR(2)           not null,
   DESCTIPOIDENTI       VARCHAR(20)          not null,
   constraint PK_TIPOIDENTIFICACION primary key (TIPOIDENTI)
);

/*==============================================================*/
/* Index: TIPOIDENTIFICACION_PK                                 */
/*==============================================================*/
create unique index TIPOIDENTIFICACION_PK on TIPOIDENTIFICACION (
TIPOIDENTI
);

/*==============================================================*/
/* Table: TIPOPERSONA                                           */
/*==============================================================*/
create table TIPOPERSONA (
   IDTIPOPERSONA        VARCHAR(2)           not null,
   DESCTIPOPERSONA      VARCHAR(20)          not null,
   constraint PK_TIPOPERSONA primary key (IDTIPOPERSONA)
);

/*==============================================================*/
/* Index: TIPOPERSONA_PK                                        */
/*==============================================================*/
create unique index TIPOPERSONA_PK on TIPOPERSONA (
IDTIPOPERSONA
);

/*==============================================================*/
/* Table: UNIDADMEDIDA                                          */
/*==============================================================*/
create table UNIDADMEDIDA (
   IDUNIDAD             VARCHAR(2)           not null,
   DESCUNIDAD           VARCHAR(20)          not null,
   constraint PK_UNIDADMEDIDA primary key (IDUNIDAD)
);

/*==============================================================*/
/* Index: UNIDADMEDIDA_PK                                       */
/*==============================================================*/
create unique index UNIDADMEDIDA_PK on UNIDADMEDIDA (
IDUNIDAD
);

alter table CONTACTO
   add constraint FK_CONTACTO_CONTACTO__PERSONA foreign key (IDTIPOPERSONAFK, IDPERSONAFK)
      references PERSONA (IDTIPOPERSONAFK, IDPERSONA)
      on delete restrict on update restrict;

alter table CONTACTO
   add constraint FK_CONTACTO_TIPOCONTA_TIPOCONT foreign key (IDTIPOCONFK)
      references TIPOCONTACTO (IDTIPOCON)
      on delete restrict on update restrict;

alter table DETALLEENSAMBLE
   add constraint FK_DETALLEE_DETALLEEN_INVENTAR foreign key (IDREFEFK, NOINVENTARIOFK)
      references INVENTARIO (IDREFEFK, NOINVENTARIO)
      on delete restrict on update restrict;

alter table DETALLEENSAMBLE
   add constraint FK_DETALLEE_ENSAMBLE__ENSAMBLE foreign key (CONSECCFK)
      references ENSAMBLE (CONSECC)
      on delete restrict on update restrict;

alter table DETALLEFACTURA
   add constraint FK_DETALLEF_DETALLEFA_ENSAMBLE foreign key (CONSECCFK)
      references ENSAMBLE (CONSECC)
      on delete restrict on update restrict;

alter table DETALLEFACTURA
   add constraint FK_DETALLEF_DETALLEFA_INVENTAR foreign key (IDREFEFK, NOINVENTARIOFK)
      references INVENTARIO (IDREFEFK, NOINVENTARIO)
      on delete restrict on update restrict;

alter table DETALLEFACTURA
   add constraint FK_DETALLEF_FACTURA_D_FACTURA foreign key (NFACTURAFK)
      references FACTURA (NFACTURA)
      on delete restrict on update restrict;

alter table DETALLEFACTURA
   add constraint FK_DETALLEF_TIPODETAL_TIPODETA foreign key (IDTIPODETALLEFK)
      references TIPODETALLE (IDTIPODETALLE)
      on delete restrict on update restrict;

alter table EMPLEADO
   add constraint FK_EMPLEADO_TIPOIDENT_TIPOIDEN foreign key (TIPOIDENTIFK)
      references TIPOIDENTIFICACION (TIPOIDENTI)
      on delete restrict on update restrict;

alter table ENSAMBLE
   add constraint FK_ENSAMBLE_EMPLEADO__EMPLEADO foreign key (CODEMPLEADOFK)
      references EMPLEADO (CODEMPLEADO)
      on delete restrict on update restrict;

alter table FACTURA
   add constraint FK_FACTURA_FACTURA_E_EMPLEADO foreign key (CODEMPLEADOFK)
      references EMPLEADO (CODEMPLEADO)
      on delete restrict on update restrict;

alter table FACTURA
   add constraint FK_FACTURA_FORMAPAGO_FORMAPAG foreign key (IDFORMAPAGOFK)
      references FORMAPAGO (IDFORMAPAGO)
      on delete restrict on update restrict;

alter table FACTURA
   add constraint FK_FACTURA_PERSONA_F_PERSONA foreign key (IDTIPOPERSONAFK, IDPERSONAFK)
      references PERSONA (IDTIPOPERSONAFK, IDPERSONA)
      on delete restrict on update restrict;

alter table FACTURA
   add constraint FK_FACTURA_TIPOFACTU_TIPOFACT foreign key (IDTIPOFACTURAFK)
      references TIPOFACTURA (IDTIPOFACTURA)
      on delete restrict on update restrict;

alter table HISTORICARGO
   add constraint FK_HISTORIC_HISTORICA_EMPLEADO foreign key (CODEMPLEADOFK)
      references EMPLEADO (CODEMPLEADO)
      on delete restrict on update restrict;

alter table HISTORICARGO
   add constraint FK_HISTORIC_TIPOCARGO_TIPOCARG foreign key (IDTIPOCARGOFK)
      references TIPOCARGO (IDTIPOCARGO)
      on delete restrict on update restrict;

alter table INVENTARIO
   add constraint FK_INVENTAR_EMPLEADO__EMPLEADO foreign key (CODEMPLEADOFK)
      references EMPLEADO (CODEMPLEADO)
      on delete restrict on update restrict;

alter table INVENTARIO
   add constraint FK_INVENTAR_FACTURA_I_FACTURA foreign key (NFACTURAFK)
      references FACTURA (NFACTURA)
      on delete restrict on update restrict;

alter table INVENTARIO
   add constraint FK_INVENTAR_INVENTARI_EVENTO foreign key (IDEVENTOFK)
      references EVENTO (IDEVENTO)
      on delete restrict on update restrict;

alter table INVENTARIO
   add constraint FK_INVENTAR_INVENTARI_REFERENC foreign key (IDREFEFK)
      references REFERENCIAELEMENTO (IDREFE)
      on delete restrict on update restrict;

alter table PERSONA
   add constraint FK_PERSONA_TIPOIDENT_TIPOIDEN foreign key (TIPOIDENTIFK)
      references TIPOIDENTIFICACION (TIPOIDENTI)
      on delete restrict on update restrict;

alter table PERSONA
   add constraint FK_PERSONA_TIPOPERSO_TIPOPERS foreign key (IDTIPOPERSONAFK)
      references TIPOPERSONA (IDTIPOPERSONA)
      on delete restrict on update restrict;

alter table REFERENCIACARACTERISTICA
   add constraint FK_REFERENC_REFERENCI_REFERENC foreign key (IDREFEFK)
      references REFERENCIAELEMENTO (IDREFE)
      on delete restrict on update restrict;

alter table REFERENCIACARACTERISTICA
   add constraint FK_REFERENC_TIPOCARAC_TIPOCARA foreign key (IDTIPOCARACFK)
      references TIPOCARACTERISTICA (IDTIPOCARAC)
      on delete restrict on update restrict;

alter table REFERENCIACARACTERISTICA
   add constraint FK_REFERENC_UNIDADMED_UNIDADME foreign key (IDUNIDADFK)
      references UNIDADMEDIDA (IDUNIDAD)
      on delete restrict on update restrict;

alter table REFERENCIAELEMENTO
   add constraint FK_REFERENC_TIPOELEME_TIPOELEM foreign key (IDTIPOELEMENFK)
      references TIPOELEMENTO (IDTIPOELEMEN)
      on delete restrict on update restrict;

