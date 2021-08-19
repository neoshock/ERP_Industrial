
package com.contabilidad.controllers;

import com.contabilidad.dao.BalanceGeneralDAO;
import com.contabilidad.models.BalanceGeneral;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import java.io.File;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.component.export.PDFOptions;
import org.primefaces.component.export.PDFOrientationType;

@Named(value = "balanceGeneralMB")
@SessionScoped
public class BalanceGeneralManagedBean implements Serializable {
    private List<BalanceGeneral> balanceGeneral;
    private BalanceGeneralDAO balanceGeneralDAO;
    
    private PDFOptions pdfOpt;
    
    
    public BalanceGeneralManagedBean() {
        balanceGeneral = new ArrayList<>();
        balanceGeneralDAO = new BalanceGeneralDAO();
    }
    
    @PostConstruct
    public void init() {
        balanceGeneral = balanceGeneralDAO.generateBalanceGeneral();
    }
    
      public void customizeLibroMayor() {
        pdfOpt = new PDFOptions();
        pdfOpt.setFacetBgColor("#CFFFFF");
        pdfOpt.setFacetFontStyle("BOLD");
        pdfOpt.setCellFontSize("12");
        pdfOpt.setOrientation(PDFOrientationType.PORTRAIT);
    }

    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();

        pdf.addTitle("Informe Balance General: ");
        pdf.setPageSize(PageSize.A4);

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "images" + File.separator + "headerbalance.png";

        Image img = Image.getInstance(logo);
        img.scalePercent(30);
        
        pdf.add(img);
    }

    public PDFOptions getPdfOpt() {
        return pdfOpt;
    }

    public void setPdfOpt(PDFOptions pdfOpt) {
        this.pdfOpt = pdfOpt;
    }
    
    
    public boolean getBold(String cuenta) {
        return cuenta.split(" ")[0].length() <= 5;
    }
    
    public double sumaPasivoPatrimonio() {
        return balanceGeneralDAO.sumaPasivoPatrimonio();
    }

    public List<BalanceGeneral> getBalanceGeneral() {
        return balanceGeneral;
    }

    public void setBalanceGeneral(List<BalanceGeneral> balanceGeneral) {
        this.balanceGeneral = balanceGeneral;
    }
    
    
}
