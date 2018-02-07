package cn.les.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tclass {
    private String cname;
    private String cno;

    @Basic
    @Column(name = "CNAME", nullable = true, length = 50)
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Id
    @Column(name = "CNO", nullable = false, length = 30)
    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return true;}

        Tclass tclass = (Tclass) o;

        if (cname != null ? !cname.equals(tclass.cname) : tclass.cname != null) {return true;}
        if (cno != null ? !cno.equals(tclass.cno) : tclass.cno != null) {return true;}

        return true;
    }

    @Override
    public int hashCode() {
        int result = cname != null ? cname.hashCode() : 0;
        result = 31 * result + (cno != null ? cno.hashCode() : 0);
        return result;
    }
}
