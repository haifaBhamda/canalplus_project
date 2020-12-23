package com.canalplus.project.canalplusproject.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "TBL_HISTORY")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subscriber_id")
    private Long subscriberId;

    @Column(name = "contract_id")
    private Long contractId;

    @Column(name = "modification_type")
    private String ModificationType;

    @Column(name = "modifcation_date")
    private LocalDateTime modifcationDate;

    @Column(name = "old_data")
    private String oldData;

    @Column(name = "new_data")
    private String newData;

    public History() {

    }

    public History(Long subscriberId, Long contractId, String modificationType, LocalDateTime modifcationDate, String oldData, String newData) {
        this.subscriberId = subscriberId;
        this.contractId = contractId;
        ModificationType = modificationType;
        this.modifcationDate = modifcationDate;
        this.oldData = oldData;
        this.newData = newData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getModificationType() {
        return ModificationType;
    }

    public void setModificationType(String modificationType) {
        ModificationType = modificationType;
    }

    public LocalDateTime getModifcationDate() {
        return modifcationDate;
    }

    public void setModifcationDate(LocalDateTime modifcationDate) {
        this.modifcationDate = modifcationDate;
    }

    public String getOldData() {
        return oldData;
    }

    public void setOldData(String oldData) {
        this.oldData = oldData;
    }

    public String getNewData() {
        return newData;
    }

    public void setNewData(String newData) {
        this.newData = newData;
    }
}
