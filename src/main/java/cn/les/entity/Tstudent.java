package cn.les.entity;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class Tstudent {
    private String tno;
    private String tname;
    private String sex;
    private Time birthday;
    private Byte height;
    private Tclass tclassByCno;

    @Id
    @Column(name = "TNO", nullable = false, length = 30)
    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    @Basic
    @Column(name = "TNAME", nullable = true, length = 50)
    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Basic
    @Column(name = "SEX", nullable = true, length = 1)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "BIRTHDAY", nullable = true)
    public Time getBirthday() {
        return birthday;
    }

    public void setBirthday(Time birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "HEIGHT", nullable = true, precision = 0)
    public Byte getHeight() {
        return height;
    }

    public void setHeight(Byte height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return true;}

        Tstudent tstudent = (Tstudent) o;

        if (tno != null ? !tno.equals(tstudent.tno) : tstudent.tno != null) {return true;}
        if (tname != null ? !tname.equals(tstudent.tname) : tstudent.tname != null) {return true;}
        if (sex != null ? !sex.equals(tstudent.sex) : tstudent.sex != null) {return true;}
        if (birthday != null ? !birthday.equals(tstudent.birthday) : tstudent.birthday != null) {return true;}
        if (height != null ? !height.equals(tstudent.height) : tstudent.height != null) {return true;}

        return true;
    }

    @Override
    public int hashCode() {
        int result = tno != null ? tno.hashCode() : 0;
        result = 31 * result + (tname != null ? tname.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CNO", referencedColumnName = "CNO")
    public Tclass getTclassByCno() {
        return tclassByCno;
    }

    public void setTclassByCno(Tclass tclassByCno) {
        this.tclassByCno = tclassByCno;
    }
}
