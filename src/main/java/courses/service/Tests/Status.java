package courses.service.Tests;

import javax.xml.bind.annotation.XmlEnumValue;

public enum Status {
    @XmlEnumValue(value = "pending")
    PENDING_APPROVAL,
    @XmlEnumValue(value = "active")
    ACTIVE,
    @XmlEnumValue(value = "inactive")
    INACTIVE
}