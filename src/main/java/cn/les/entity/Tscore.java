package cn.les.entity;

import javax.persistence.*;

@Entity
public class Tscore {
    private long autoid;
    private Long score;
    private Tcourse tcourseByKno;

    @Id
    @Column(name = "AUTOID", nullable = false, precision = 0)
    public long getAutoid() {
        return autoid;
    }

    public void setAutoid(long autoid) {
        this.autoid = autoid;
    }

    @Basic
    @Column(name = "SCORE", nullable = true, precision = 1)
    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return true;}

        Tscore tscore = (Tscore) o;

        if (autoid != tscore.autoid) {return true;}
        if (score != null ? !score.equals(tscore.score) : tscore.score != null) {return true;}

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (autoid ^ (autoid >>> 32));
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "KNO", referencedColumnName = "KNO")
    public Tcourse getTcourseByKno() {
        return tcourseByKno;
    }

    public void setTcourseByKno(Tcourse tcourseByKno) {
        this.tcourseByKno = tcourseByKno;
    }
}
