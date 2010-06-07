<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://www.icesoft.com/icefaces/component" prefix="ice"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Sistema de Gestión Humana</title>
<link rel="stylesheet" type="text/css"
	href="../../xmlhttp/css/xp/xp.css" />
</head>
<body>
<f:view>
	<ice:form>
		<f:loadBundle basename="co.com.fc.etiquetas.bundle" var="etiqueta" />
		<table cellpadding="1" cellspacing="10">
			<tr>
				<td><ice:commandLink value="#{etiqueta.menu_0}"
					action="#{ingreso.validarIngresoUsuario}" id="id_menu_0" /></td>
				<td><ice:commandLink value="#{etiqueta.menu_2}"
					action="#{ingreso.irARadicarSolicitudPersonal}" id="id_menu_2" />
				</td>
				<td><ice:commandLink value="#{etiqueta.menu_1}"
					action="#{ingreso.salir}" /></td>
			</tr>
		</table>
		<br>
		<table width="100%" align="center" height="60%">
			<tr>
				<td>
				<table border="0" cellspacing="3" width="780" align="center"
					bgcolor="FFFFFF">
					<thead class="encabezadoTablaBandeja">
						<tr>
							<td align="center" bgcolor="#E0EFF2"><ice:outputText
								value="#{etiqueta.lbl_bandeja_solicitudes}" /></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td align="center"><ice:dataTable id="tareasUsuario"
								value="#{ingreso.listaTareasPendientes}" var="tarea"
								headerClass="iceDatTblColHdr" width="98%" border="1"
								cellspacing="5">

								<ice:column>
									<f:facet name="header">
										<ice:outputText value="#{etiqueta.lbl_num_solicitud}" />
									</f:facet>

									<ice:commandLink action="#{ingreso.verDetalleSolicitud}">
										<f:param value="#{tarea.processId}" name="orderId" />
										<f:param value="#{tarea.taskId}" name="taskId" />
										<f:param value="#{tarea.taskName}" name="taskName" />

										<ice:outputText value="#{tarea.processId}"
											style="text-align: center"
											title="Presione aqui, para ver la solicitud" />
									</ice:commandLink>
								</ice:column>

								<ice:column>
									<f:facet name="header">
										<ice:outputText value="#{etiqueta.lbl_identificacion_cliente}" />
									</f:facet>
									<ice:outputText value="#{tarea.customerId}" />
								</ice:column>

								<ice:column>
									<f:facet name="header">
										<ice:outputText value="#{etiqueta.lbl_nombre_cliente}" />
									</f:facet>
									<ice:outputText value="#{tarea.custumerName}" />
								</ice:column>

								<ice:column>
									<f:facet name="header">
										<ice:outputText value="#{etiqueta.lbl_nombre_tarea}" />
									</f:facet>
									<ice:outputText value="#{tarea.taskName}" />
								</ice:column>

								<ice:column>
									<f:facet name="header">
										<ice:outputText value="#{etiqueta.lbl_fecha_creacion}" />
									</f:facet>
									<ice:outputText value="#{tarea.createDate}" />
								</ice:column>

								<ice:column>
									<f:facet name="header">
										<ice:outputText value="#{etiqueta.lbl_num_dias_proceso}" />
									</f:facet>
									<ice:outputText value="#{tarea.numberProcessDays}" />
								</ice:column>

							</ice:dataTable></td>
						</tr>
					</tbody>
				</table>
				</td>
			</tr>
			<tr>
				<td align="center"><ice:messages /></td>
			</tr>
		</table>
	</ice:form>
</f:view>
</body>
</html>
