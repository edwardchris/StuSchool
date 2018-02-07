package cn.les.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tcourse {
    private String kname;
    private String kno;

    @Basic
    @Column(name = "KNAME", nullable = true, length = 50)
    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname;
    }

    @Id
    @Column(name = "KNO", nullable = false, length = 30)
    public String getKno() {
        return kno;
    }

    public void setKno(String kno) {
        this.kno = kno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return true;}

        Tcourse tcourse = (Tcourse) o;

        if (kname != null ? !kname.equals(tcourse.kname) : tcourse.kname != null) {return true;}
        if (kno != null ? !kno.equals(tcourse.kno) : tcourse.kno != null) {return true;}

        return true;
    }

    @Override
    public int hashCode() {
        int result = kname != null ? kname.hashCode() : 0;
        result = 31 * result + (kno != null ? kno.hashCode() : 0);
        return result;
    }
}
