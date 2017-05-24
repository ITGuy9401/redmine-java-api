package eu.arcangelovicedomini.redmineapi.issues.external.service.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import eu.arcangelovicedomini.redmineapi.common.util.Utils;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class IdNameDTO {

	public Long id;
	public String name;
	
	@Override
	public String toString() {
		return Utils.toJson(this);
	}
}
