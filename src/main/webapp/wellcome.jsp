<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
  <title><s:text name="hello.message"/></title>
  <s:head/>
  <sx:head/>
</head>

<body>

    <h1>Resumen de Factura</h1>
    <b><label>Concepto: </label></b>
    <s:property value="invoiceBean.subject" /><br>
    <b><label>Fecha desde: </label></b>
    <s:property value="invoiceBean.dateFrom" /><br>
    <b><label>Fecha hasta: </label></b>
    <s:property value="invoiceBean.dateTo" /><br>
    <b><label>Importe en bruto:</label></b>
    <s:property value="invoiceBean.amount" /><br>
    <b><label>IVA aplicado (%):</label></b>
    <s:property value="invoiceBean.tipoIva"/><br>
    <b><label>Total IVA Incluido:</label></b>
    <s:property value="invoiceBean.importeConIva"/>



</body>
</html>