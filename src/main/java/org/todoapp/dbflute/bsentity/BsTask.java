/*
 * Copyright 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.todoapp.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.Entity;
import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import org.dbflute.optional.OptionalEntity;
import org.todoapp.dbflute.allcommon.DBMetaInstanceHandler;
import org.todoapp.dbflute.allcommon.CDef;
import org.todoapp.dbflute.exentity.*;

/**
 * The entity of TASK as TABLE. <br>
 * <pre>
 * [primary-key]
 *     TASK_ID
 *
 * [column]
 *     TASK_ID, DESCRIPTION, TASK_STATUS_CODE
 *
 * [sequence]
 *     
 *
 * [identity]
 *     TASK_ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     TASK_STATUS
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     taskStatus
 *
 * [referrer property]
 *     
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Long taskId = entity.getTaskId();
 * String description = entity.getDescription();
 * String taskStatusCode = entity.getTaskStatusCode();
 * entity.setTaskId(taskId);
 * entity.setDescription(description);
 * entity.setTaskStatusCode(taskStatusCode);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsTask extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** TASK_ID: {PK, ID, NotNull, BIGINT(19)} */
    protected Long _taskId;

    /** DESCRIPTION: {NotNull, TEXT(65535)} */
    protected String _description;

    /** TASK_STATUS_CODE: {IX, NotNull, CHAR(3), FK to TASK_STATUS, classification=TaskStatus} */
    protected String _taskStatusCode;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "TASK";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_taskId == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of taskStatusCode as the classification of TaskStatus. <br>
     * TASK_STATUS_CODE: {IX, NotNull, CHAR(3), FK to TASK_STATUS, classification=TaskStatus} <br>
     * status of task
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.TaskStatus getTaskStatusCodeAsTaskStatus() {
        return CDef.TaskStatus.codeOf(getTaskStatusCode());
    }

    /**
     * Set the value of taskStatusCode as the classification of TaskStatus. <br>
     * TASK_STATUS_CODE: {IX, NotNull, CHAR(3), FK to TASK_STATUS, classification=TaskStatus} <br>
     * status of task
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setTaskStatusCodeAsTaskStatus(CDef.TaskStatus cdef) {
        setTaskStatusCode(cdef != null ? cdef.code() : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of taskStatusCode as NotStartedYet (YET). <br>
     * NotStartedYet: 未着手
     */
    public void setTaskStatusCode_NotStartedYet() {
        setTaskStatusCodeAsTaskStatus(CDef.TaskStatus.NotStartedYet);
    }

    /**
     * Set the value of taskStatusCode as WorkInProgress2 (WIP). <br>
     * WorkInProgress2: 進行中
     */
    public void setTaskStatusCode_WorkInProgress2() {
        setTaskStatusCodeAsTaskStatus(CDef.TaskStatus.WorkInProgress2);
    }

    /**
     * Set the value of taskStatusCode as Completed (CMP). <br>
     * Completed: 完了
     */
    public void setTaskStatusCode_Completed() {
        setTaskStatusCodeAsTaskStatus(CDef.TaskStatus.Completed);
    }

    /**
     * Set the value of taskStatusCode as Deleted (DEL). <br>
     * Deleted: 削除
     */
    public void setTaskStatusCode_Deleted() {
        setTaskStatusCodeAsTaskStatus(CDef.TaskStatus.Deleted);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of taskStatusCode NotStartedYet? <br>
     * NotStartedYet: 未着手
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isTaskStatusCodeNotStartedYet() {
        CDef.TaskStatus cdef = getTaskStatusCodeAsTaskStatus();
        return cdef != null ? cdef.equals(CDef.TaskStatus.NotStartedYet) : false;
    }

    /**
     * Is the value of taskStatusCode WorkInProgress2? <br>
     * WorkInProgress2: 進行中
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isTaskStatusCodeWorkInProgress2() {
        CDef.TaskStatus cdef = getTaskStatusCodeAsTaskStatus();
        return cdef != null ? cdef.equals(CDef.TaskStatus.WorkInProgress2) : false;
    }

    /**
     * Is the value of taskStatusCode Completed? <br>
     * Completed: 完了
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isTaskStatusCodeCompleted() {
        CDef.TaskStatus cdef = getTaskStatusCodeAsTaskStatus();
        return cdef != null ? cdef.equals(CDef.TaskStatus.Completed) : false;
    }

    /**
     * Is the value of taskStatusCode Deleted? <br>
     * Deleted: 削除
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isTaskStatusCodeDeleted() {
        CDef.TaskStatus cdef = getTaskStatusCodeAsTaskStatus();
        return cdef != null ? cdef.equals(CDef.TaskStatus.Deleted) : false;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** TASK_STATUS by my TASK_STATUS_CODE, named 'taskStatus'. */
    protected OptionalEntity<TaskStatus> _taskStatus;

    /**
     * [get] TASK_STATUS by my TASK_STATUS_CODE, named 'taskStatus'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'taskStatus'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<TaskStatus> getTaskStatus() {
        if (_taskStatus == null) { _taskStatus = OptionalEntity.relationEmpty(this, "taskStatus"); }
        return _taskStatus;
    }

    /**
     * [set] TASK_STATUS by my TASK_STATUS_CODE, named 'taskStatus'.
     * @param taskStatus The entity of foreign property 'taskStatus'. (NullAllowed)
     */
    public void setTaskStatus(OptionalEntity<TaskStatus> taskStatus) {
        _taskStatus = taskStatus;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsTask) {
            BsTask other = (BsTask)obj;
            if (!xSV(_taskId, other._taskId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _taskId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_taskStatus != null && _taskStatus.isPresent())
        { sb.append(li).append(xbRDS(_taskStatus, "taskStatus")); }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_taskId));
        sb.append(dm).append(xfND(_description));
        sb.append(dm).append(xfND(_taskStatusCode));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_taskStatus != null && _taskStatus.isPresent())
        { sb.append(dm).append("taskStatus"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public Task clone() {
        return (Task)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] TASK_ID: {PK, ID, NotNull, BIGINT(19)} <br>
     * @return The value of the column 'TASK_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getTaskId() {
        checkSpecifiedProperty("taskId");
        return _taskId;
    }

    /**
     * [set] TASK_ID: {PK, ID, NotNull, BIGINT(19)} <br>
     * @param taskId The value of the column 'TASK_ID'. (basically NotNull if update: for the constraint)
     */
    public void setTaskId(Long taskId) {
        registerModifiedProperty("taskId");
        _taskId = taskId;
    }

    /**
     * [get] DESCRIPTION: {NotNull, TEXT(65535)} <br>
     * @return The value of the column 'DESCRIPTION'. (basically NotNull if selected: for the constraint)
     */
    public String getDescription() {
        checkSpecifiedProperty("description");
        return convertEmptyToNull(_description);
    }

    /**
     * [set] DESCRIPTION: {NotNull, TEXT(65535)} <br>
     * @param description The value of the column 'DESCRIPTION'. (basically NotNull if update: for the constraint)
     */
    public void setDescription(String description) {
        registerModifiedProperty("description");
        _description = description;
    }

    /**
     * [get] TASK_STATUS_CODE: {IX, NotNull, CHAR(3), FK to TASK_STATUS, classification=TaskStatus} <br>
     * @return The value of the column 'TASK_STATUS_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getTaskStatusCode() {
        checkSpecifiedProperty("taskStatusCode");
        return convertEmptyToNull(_taskStatusCode);
    }

    /**
     * [set] TASK_STATUS_CODE: {IX, NotNull, CHAR(3), FK to TASK_STATUS, classification=TaskStatus} <br>
     * @param taskStatusCode The value of the column 'TASK_STATUS_CODE'. (basically NotNull if update: for the constraint)
     */
    protected void setTaskStatusCode(String taskStatusCode) {
        checkClassificationCode("TASK_STATUS_CODE", CDef.DefMeta.TaskStatus, taskStatusCode);
        registerModifiedProperty("taskStatusCode");
        _taskStatusCode = taskStatusCode;
    }

    /**
     * For framework so basically DON'T use this method.
     * @param taskStatusCode The value of the column 'TASK_STATUS_CODE'. (basically NotNull if update: for the constraint)
     */
    public void mynativeMappingTaskStatusCode(String taskStatusCode) {
        setTaskStatusCode(taskStatusCode);
    }
}
