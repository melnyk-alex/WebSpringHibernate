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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "student_groups", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"number"})})
@NamedQueries({
    @NamedQuery(name = "StudentGroup.findAll", query = "SELECT s FROM StudentGroup s"),
    @NamedQuery(name = "StudentGroup.findById", query = "SELECT s FROM StudentGroup s WHERE s.id = :id"),
    @NamedQuery(name = "StudentGroup.findByNumber", query = "SELECT s FROM StudentGroup s WHERE s.number = :number"),
    @NamedQuery(name = "StudentGroup.findByBegin", query = "SELECT s FROM StudentGroup s WHERE s.begin = :begin")})
public class StudentGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String number;
    @Temporal(TemporalType.DATE)
    private Date begin;
    @ManyToMany(mappedBy = "studentGroupList")
    private List<Student> studentList;
    @ManyToMany(mappedBy = "studentGroupList")
    private List<Course> courseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentGroupsId")
    private List<HistoryOfLesson> historyOfLessonList;
    @JoinColumn(name = "time_table_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Schedule timeTableId;
    @JoinColumn(name = "trainers_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Trainer trainersId;

    public StudentGroup() {
    }

    public StudentGroup(Integer id) {
        this.id = id;
    }

    public StudentGroup(Integer id, String number) {
        this.id = id;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<HistoryOfLesson> getHistoryOfLessonList() {
        return historyOfLessonList;
    }

    public void setHistoryOfLessonList(List<HistoryOfLesson> historyOfLessonList) {
        this.historyOfLessonList = historyOfLessonList;
    }

    public Schedule getTimeTableId() {
        return timeTableId;
    }

    public void setTimeTableId(Schedule timeTableId) {
        this.timeTableId = timeTableId;
    }

    public Trainer getTrainersId() {
        return trainersId;
    }

    public void setTrainersId(Trainer trainersId) {
        this.trainersId = trainersId;
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
        if (!(object instanceof StudentGroup)) {
            return false;
        }
        StudentGroup other = (StudentGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.com.codefire.testhiber.db.entity.StudentGroup[ id=" + id + " ]";
    }
    
}
