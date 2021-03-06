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
package org.todoapp.dbflute.cbean.cq.bs;

import org.dbflute.cbean.ConditionQuery;
import org.dbflute.cbean.chelper.HpQDRFunction;
import org.dbflute.cbean.coption.ConditionOption;
import org.dbflute.cbean.cvalue.ConditionValue;
import org.dbflute.cbean.sqlclause.SqlClause;
import org.dbflute.exception.IllegalConditionBeanOperationException;
import org.todoapp.dbflute.cbean.TaskCB;
import org.todoapp.dbflute.cbean.cq.TaskCQ;
import org.todoapp.dbflute.cbean.cq.TaskStatusCQ;
import org.todoapp.dbflute.cbean.cq.ciq.TaskCIQ;

import java.util.Map;

/**
 * The base condition-query of TASK.
 * @author DBFlute(AutoGenerator)
 */
public class BsTaskCQ extends AbstractBsTaskCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected TaskCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsTaskCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from TASK) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public TaskCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected TaskCIQ xcreateCIQ() {
        TaskCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected TaskCIQ xnewCIQ() {
        return new TaskCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join TASK on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public TaskCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        TaskCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _taskId;
    public ConditionValue xdfgetTaskId()
    { if (_taskId == null) { _taskId = nCV(); }
      return _taskId; }
    protected ConditionValue xgetCValueTaskId() { return xdfgetTaskId(); }

    /** 
     * Add order-by as ascend. <br>
     * TASK_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsTaskCQ addOrderBy_TaskId_Asc() { regOBA("TASK_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * TASK_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsTaskCQ addOrderBy_TaskId_Desc() { regOBD("TASK_ID"); return this; }

    protected ConditionValue _description;
    public ConditionValue xdfgetDescription()
    { if (_description == null) { _description = nCV(); }
      return _description; }
    protected ConditionValue xgetCValueDescription() { return xdfgetDescription(); }

    protected ConditionValue _taskStatusCode;
    public ConditionValue xdfgetTaskStatusCode()
    { if (_taskStatusCode == null) { _taskStatusCode = nCV(); }
      return _taskStatusCode; }
    protected ConditionValue xgetCValueTaskStatusCode() { return xdfgetTaskStatusCode(); }

    /** 
     * Add order-by as ascend. <br>
     * TASK_STATUS_CODE: {IX, NotNull, CHAR(3), FK to TASK_STATUS, classification=TaskStatus}
     * @return this. (NotNull)
     */
    public BsTaskCQ addOrderBy_TaskStatusCode_Asc() { regOBA("TASK_STATUS_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * TASK_STATUS_CODE: {IX, NotNull, CHAR(3), FK to TASK_STATUS, classification=TaskStatus}
     * @return this. (NotNull)
     */
    public BsTaskCQ addOrderBy_TaskStatusCode_Desc() { regOBD("TASK_STATUS_CODE"); return this; }

    // ===================================================================================
    //                                                             SpecifiedDerivedOrderBy
    //                                                             =======================
    /**
     * Add order-by for specified derived column as ascend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #CC4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] asc</span>
     * cb.<span style="color: #CC4747">addSpecifiedDerivedOrderBy_Asc</span>(<span style="color: #CC4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsTaskCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

    /**
     * Add order-by for specified derived column as descend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #CC4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] desc</span>
     * cb.<span style="color: #CC4747">addSpecifiedDerivedOrderBy_Desc</span>(<span style="color: #CC4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsTaskCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        TaskCQ bq = (TaskCQ)bqs;
        TaskCQ uq = (TaskCQ)uqs;
        if (bq.hasConditionQueryTaskStatus()) {
            uq.queryTaskStatus().reflectRelationOnUnionQuery(bq.queryTaskStatus(), uq.queryTaskStatus());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br>
     * TASK_STATUS by my TASK_STATUS_CODE, named 'taskStatus'.
     * @return The instance of condition-query. (NotNull)
     */
    public TaskStatusCQ queryTaskStatus() {
        return xdfgetConditionQueryTaskStatus();
    }
    public TaskStatusCQ xdfgetConditionQueryTaskStatus() {
        String prop = "taskStatus";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryTaskStatus()); xsetupOuterJoinTaskStatus(); }
        return xgetQueRlMap(prop);
    }
    protected TaskStatusCQ xcreateQueryTaskStatus() {
        String nrp = xresolveNRP("TASK", "taskStatus"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new TaskStatusCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "taskStatus", nrp);
    }
    protected void xsetupOuterJoinTaskStatus() { xregOutJo("taskStatus"); }
    public boolean hasConditionQueryTaskStatus() { return xhasQueRlMap("taskStatus"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, TaskCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(TaskCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, TaskCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(TaskCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, TaskCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(TaskCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, TaskCQ> _myselfExistsMap;
    public Map<String, TaskCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(TaskCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, TaskCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(TaskCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return TaskCB.class.getName(); }
    protected String xCQ() { return TaskCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
