package eu.arcangelovicedomini.redmineapi.issues.external.service.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import eu.arcangelovicedomini.redmineapi.common.util.Utils;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class IssueDTO {

	public Long id;
	public IdNameDTO project;
	public IdNameDTO tracker;
	public IdNameDTO status;
	public IdNameDTO priority;
	public IdNameDTO author;
	@XmlAttribute(name = "assigned_to")
	public IdNameDTO assignedTo;
	@XmlAttribute(name = "fixed_version")
	public IdNameDTO fixedVersion;
	
	public String subject;
	public String description;
	@XmlAttribute(name = "start_date")
	public Date startDate;
	@XmlAttribute(name = "due_date")
	public Date dueDate;
	@XmlAttribute(name = "done_ratio")
	public Integer doneRatio;
	@XmlAttribute(name = "estimated_hours")
	public Double estimatedHours;
	@XmlAttribute(name = "created_on")
	public Date createdOn;
	@XmlAttribute(name = "updated_on")
	public Date updatedOn;
	
	@Override
	public String toString() {
		return Utils.toJson(this);
	}
}
