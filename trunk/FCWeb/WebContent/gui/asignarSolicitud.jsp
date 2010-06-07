<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://www.icesoft.com/icefaces/component" prefix="ice"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Verificar Documentos Solicitud de Personal</title>
<link rel="stylesheet" type="text/css" href="../xmlhttp/css/xp/xp.css" />
</head>
<body>
<f:view>
	<ice:form partialSubmit="true">
		<f:loadBundle basename="co.com.fc.etiquetas.bundle" var="etiqueta" />
		<table cellpadding="1" cellspacing="10">
			<tr>
				<td><ice:commandLink value="#{etiqueta.menu_0}"
					action="#{ingreso.validarIngresoUsuario}" id="id_menu_0" /></td>
				<td><ice:commandLink value="#{etiqueta.menu_1}"
					action="#{ingreso.salir}" /></td>
			</tr>
		</table>
		<br>
		<table width="100%" align="center" height="60%">
			<tr>
				<td>
				<table cellpadding="1" cellspacing="10" border="1" align="center">
					<thead>
						<tr>
							<td colspan="2" align="center" bgcolor="#E0EFF2"><ice:outputText
								value="#{etiqueta.lbl_asignacion_solicitud}" /></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td align="right"><ice:outputText
								value="#{etiqueta.lbl_identificacion_cliente}" /></td>
							<td align="left"><ice:outputText
								value="#{asignarSolicitud.identificacionCliente}" /></td>
						</tr>
						<tr>
							<td align="right"><ice:outputText
								value="#{etiqueta.lbl_nombre_cliente}" /></td>
							<td align="left"><ice:outputText
								value="#{asignarSolicitud.nombreCliente}" /></td>
						</tr>
						<tr>
							<td align="right"><ice:outputText
								value="#{etiqueta.lbl_nombre_cargo}" /></td>
							<td align="left"><ice:outputText
								value="#{asignarSolicitud.nombreCargo}" /></td>
						</tr>

						<tr>
							<td align="right"><ice:outputText
								value="#{etiqueta.lbl_usuario}" /></td>
							<td><ice:inputText
								value="#{asignarSolicitud.usuarioAsignado}"></ice:inputText></td>
						</tr>
						<tr>
							<td align="right"><ice:outputText
								value="#{etiqueta.lbl_ingresar_observaciones}" /></td>
							<td align="left"><ice:inputTextarea
								value="#{verficaDocumentosSolicitudPersonal.observaciones}"
								rows="5" cols="40"></ice:inputTextarea></td>
						</tr>
						<tr>
							<td align="center" colspan="2"><ice:commandButton
								value="#{etiqueta.btn_asignar_solicitud}"
								action="#{asignarSolicitud.asignar_solicitudes}" /> &nbsp; <ice:commandButton
								value="#{etiqueta.btn_limpiar}"
								action="#{asignarSolicitud.limpiar}" /></td>
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
