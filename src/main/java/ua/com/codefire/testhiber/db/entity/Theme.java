/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.testhiber.db.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author human
 */
@Entity
@Table(name = "themes", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
@NamedQueries({
    @NamedQuery(name = "Theme.findAll", query = "SELECT t FROM Theme t"),
    @NamedQuery(name = "Theme.findById", query = "SELECT t FROM Theme t WHERE t.id = :id"),
    @NamedQuery(name = "Theme.findByName", query = "SELECT t FROM Theme t WHERE t.name = :name")})
public class Theme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String name;
    @Lob
    @Column(length = 65535)
    private String description;
    @ManyToMany(mappedBy = "themeList")
    private List<Course> courseList;
    @JoinTable(name = "trainers_has_themes", joinColumns = {
        @JoinColumn(name = "themes_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "trainers_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private List<Trainer> trainerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "themesId")
    private List<HistoryOfLesson> historyOfLessonList;

    public Theme() {
    }

    public Theme(Integer id) {
        this.id = id;
    }

    public Theme(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Trainer> getTrainerList() {
        return trainerList;
    }

    public void setTrainerList(List<Trainer> trainerList) {
        this.trainerList = trainerList;
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
        if (!(object instanceof Theme)) {
            return false;
        }
        Theme other = (Theme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.com.codefire.testhiber.db.entity.Theme[ id=" + id + " ]";
    }
    
}
