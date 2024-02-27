package org.demo.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.demo.actions.beans.InvoiceBean;

import java.text.DecimalFormat;


public class InvoiceAction extends ActionSupport  {

    InvoiceBean invoiceBean;

    @Override
    public String execute() throws Exception {
        System.out.println("execute!!");
        double totalAmount = calculateTotalAmount();
        invoiceBean.setImporteConIva(String.valueOf(totalAmount));
        return SUCCESS;
    }

    public InvoiceBean getInvoiceBean() {
        return invoiceBean;
    }

    public void setInvoiceBean(InvoiceBean invoiceBean) {
        this.invoiceBean = invoiceBean;
    }
    @Override
    public void validate() {
        if (invoiceBean.getSubject().isEmpty()) {
            addFieldError("invoiceBean.subject", "El concepto es obligatorio.");
        }
        if (invoiceBean.getAmount().isEmpty()) {
            addFieldError("invoiceBean.amount", "El importe es obligatorio." );
        }
        if (invoiceBean.getTipoIva().isEmpty()) {
            addFieldError("invoiceBean.tipoIva", "El tipo de IVA es obligatorio.");
        }
        if (invoiceBean.getDateTo() == null) {
            addFieldError("invoiceBean.dateTo", "La fecha es obligatoria.");
        }
        if (invoiceBean.getDateFrom() == null) {
            addFieldError("invoiceBean.dateFrom", "La fecha es obligatoria.");
        }

    }

    private double calculateTotalAmount() {
        double ivaPorcentaje = Double.valueOf(invoiceBean.getTipoIva()) / 100;
        double totalAmount = Double.parseDouble(invoiceBean.getAmount()) * (1 + ivaPorcentaje);

        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(totalAmount));
    }

}
