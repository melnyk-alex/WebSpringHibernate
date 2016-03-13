/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.testhiber.db.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author human
 */
@Entity
@Table(name = "schedules", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"lesson_time"}),
    @UniqueConstraint(columnNames = {"weak_days"})})
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s"),
    @NamedQuery(name = "Schedule.findById", query = "SELECT s FROM Schedule s WHERE s.id = :id"),
    @NamedQuery(name = "Schedule.findByWeakDays", query = "SELECT s FROM Schedule s WHERE s.weakDays = :weakDays"),
    @NamedQuery(name = "Schedule.findByLessonTime", query = "SELECT s FROM Schedule s WHERE s.lessonTime = :lessonTime")})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "weak_days", nullable = false, length = 255)
    private String weakDays;
    @Basic(optional = false)
    @Column(name = "lesson_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date lessonTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timeTableId")
    private List<StudentGroup> studentGroupList;

    public Schedule() {
    }

    public Schedule(Integer id) {
        this.id = id;
    }

    public Schedule(Integer id, String weakDays, Date lessonTime) {
        this.id = id;
        this.weakDays = weakDays;
        this.lessonTime = lessonTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeakDays() {
        return weakDays;
    }

    public void setWeakDays(String weakDays) {
        this.weakDays = weakDays;
    }

    public Date getLessonTime() {
        return lessonTime;
    }

    public void setLessonTime(Date lessonTime) {
        this.lessonTime = lessonTime;
    }

    public List<StudentGroup> getStudentGroupList() {
        return studentGroupList;
    }

    public void setStudentGroupList(List<StudentGroup> studentGroupList) {
        this.studentGroupList = studentGroupList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.com.codefire.testhiber.db.entity.Schedule[ id=" + id + " ]";
    }
    
}
