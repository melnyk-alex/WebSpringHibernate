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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author human
 */
@Entity
@Table(name = "history_of_lessons")
@NamedQueries({
    @NamedQuery(name = "HistoryOfLesson.findAll", query = "SELECT h FROM HistoryOfLesson h"),
    @NamedQuery(name = "HistoryOfLesson.findById", query = "SELECT h FROM HistoryOfLesson h WHERE h.id = :id"),
    @NamedQuery(name = "HistoryOfLesson.findByTimestamp", query = "SELECT h FROM HistoryOfLesson h WHERE h.timestamp = :timestamp")})
public class HistoryOfLesson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @JoinTable(name = "students_has_history_of_lessons", joinColumns = {
        @JoinColumn(name = "history_of_lessons_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private List<Student> studentList;
    @JoinColumn(name = "student_groups_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private StudentGroup studentGroupsId;
    @JoinColumn(name = "themes_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Theme themesId;

    public HistoryOfLesson() {
    }

    public HistoryOfLesson(Integer id) {
        this.id = id;
    }

    public HistoryOfLesson(Integer id, Date timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public StudentGroup getStudentGroupsId() {
        return studentGroupsId;
    }

    public void setStudentGroupsId(StudentGroup studentGroupsId) {
        this.studentGroupsId = studentGroupsId;
    }

    public Theme getThemesId() {
        return themesId;
    }

    public void setThemesId(Theme themesId) {
        this.themesId = themesId;
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
        if (!(object instanceof HistoryOfLesson)) {
            return false;
        }
        HistoryOfLesson other = (HistoryOfLesson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.com.codefire.testhiber.db.entity.HistoryOfLesson[ id=" + id + " ]";
    }
    
}
