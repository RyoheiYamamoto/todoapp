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
package org.todoapp.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.dbflute.Entity;
import org.dbflute.optional.OptionalEntity;
import org.dbflute.dbmeta.AbstractDBMeta;
import org.dbflute.dbmeta.info.*;
import org.dbflute.dbmeta.name.*;
import org.dbflute.dbmeta.property.PropertyGateway;
import org.dbflute.dbway.DBDef;
import org.todoapp.dbflute.allcommon.*;
import org.todoapp.dbflute.exentity.*;

/**
 * The DB meta of TASK. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class TaskDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final TaskDbm _instance = new TaskDbm();
    private TaskDbm() {}
    public static TaskDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public String getProjectName() { return DBCurrent.getInstance().projectName(); }
    public String getProjectPrefix() { return DBCurrent.getInstance().projectPrefix(); }
    public String getGenerationGapBasePrefix() { return DBCurrent.getInstance().generationGapBasePrefix(); }
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    // -----------------------------------------------------
    //                                       Column Property
    //                                       ---------------
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    { xsetupEpg(); }
    protected void xsetupEpg() {
        setupEpg(_epgMap, et -> ((Task)et).getTaskId(), (et, vl) -> ((Task)et).setTaskId(ctl(vl)), "taskId");
        setupEpg(_epgMap, et -> ((Task)et).getDescription(), (et, vl) -> ((Task)et).setDescription((String)vl), "description");
        setupEpg(_epgMap, et -> ((Task)et).getTaskStatusCode(), (et, vl) -> {
            CDef.TaskStatus cls = (CDef.TaskStatus)gcls(et, columnTaskStatusCode(), vl);
            if (cls != null) {
                ((Task)et).setTaskStatusCodeAsTaskStatus(cls);
            } else {
                ((Task)et).mynativeMappingTaskStatusCode((String)vl);
            }
        }, "taskStatusCode");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    protected final Map<String, PropertyGateway> _efpgMap = newHashMap();
    { xsetupEfpg(); }
    @SuppressWarnings("unchecked")
    protected void xsetupEfpg() {
        setupEfpg(_efpgMap, et -> ((Task)et).getTaskStatus(), (et, vl) -> ((Task)et).setTaskStatus((OptionalEntity<TaskStatus>)vl), "taskStatus");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "TASK";
    protected final String _tableDispName = "TASK";
    protected final String _tablePropertyName = "task";
    protected final TableSqlName _tableSqlName = new TableSqlName("TASK", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnTaskId = cci("TASK_ID", "TASK_ID", null, null, Long.class, "taskId", null, true, true, true, "BIGINT", 19, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnDescription = cci("DESCRIPTION", "DESCRIPTION", null, null, String.class, "description", null, false, false, true, "TEXT", 65535, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnTaskStatusCode = cci("TASK_STATUS_CODE", "TASK_STATUS_CODE", null, null, String.class, "taskStatusCode", null, false, false, true, "CHAR", 3, 0, null, false, null, null, "taskStatus", null, CDef.DefMeta.TaskStatus, false);

    /**
     * TASK_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnTaskId() { return _columnTaskId; }
    /**
     * DESCRIPTION: {NotNull, TEXT(65535)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDescription() { return _columnDescription; }
    /**
     * TASK_STATUS_CODE: {IX, NotNull, CHAR(3), FK to TASK_STATUS, classification=TaskStatus}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnTaskStatusCode() { return _columnTaskStatusCode; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnTaskId());
        ls.add(columnDescription());
        ls.add(columnTaskStatusCode());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnTaskId()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    /**
     * TASK_STATUS by my TASK_STATUS_CODE, named 'taskStatus'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignTaskStatus() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnTaskStatusCode(), TaskStatusDbm.getInstance().columnTaskStatusCode());
        return cfi("FK_TASK_TASK_STATUS_TASK_STATUS_CODE", "taskStatus", this, TaskStatusDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "taskList", false);
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasIdentity() { return true; }

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "org.todoapp.dbflute.exentity.Task"; }
    public String getConditionBeanTypeName() { return "org.todoapp.dbflute.cbean.TaskCB"; }
    public String getBehaviorTypeName() { return "org.todoapp.dbflute.exbhv.TaskBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Task> getEntityType() { return Task.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Task newEntity() { return new Task(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((Task)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((Task)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
