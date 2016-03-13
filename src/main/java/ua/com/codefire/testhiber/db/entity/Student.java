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
@Table(name = "students")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id"),
    @NamedQuery(name = "Student.findByName", query = "SELECT s FROM Student s WHERE s.name = :name"),
    @NamedQuery(name = "Student.findBySurname", query = "SELECT s FROM Student s WHERE s.surname = :surname"),
    @NamedQuery(name = "Student.findByBirthday", query = "SELECT s FROM Student s WHERE s.birthday = :birthday")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(length = 255)
    private String name;
    @Column(length = 255)
    private String surname;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @JoinTable(name = "student_groups_has_students", joinColumns = {
        @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "student_groups_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private List<StudentGroup> studentGroupList;
    @ManyToMany(mappedBy = "studentList")
    private List<HistoryOfLesson> historyOfLessonList;

    public Student() {
    }

    public Student(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<StudentGroup> getStudentGroupList() {
        return studentGroupList;
    }

    public void setStudentGroupList(List<StudentGroup> studentGroupList) {
        this.studentGroupList = studentGroupList;
    }

    public List<HistoryOfLesson> getHistoryOfLessonList() {
        return historyOfLessonList;
    }

    public void setHistoryOfLessonList(List<HistoryOfLesson> historyOfLessonList) {
        this.historyOfLessonList = historyOfLessonList;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.com.codefire.testhiber.db.entity.Student[ id=" + id + " ]";
    }
    
}
