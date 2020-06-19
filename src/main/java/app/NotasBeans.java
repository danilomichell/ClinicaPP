package app;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NotasBeans {

    private double nota1, nota2, nota3, nota4, notaFinal;
    private String status;

    public NotasBeans() {
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getNota4() {
        return nota4;
    }

    public void setNota4(double nota4) {
        this.nota4 = nota4;
    }

    public double getNotaFinal() {
        this.notaFinal = (nota1 + nota2 + nota3 + nota4) / 4;
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public String getStatus() {
        status = "";
        if (this.notaFinal >= 6) {
            this.status = "Aprovado";
        } else if (this.notaFinal < 6 && this.notaFinal >= 4) {
            this.status = "Prova final";
        }
        else if (this.notaFinal < 4) {
            this.status = "Reprovado";
        }
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
