/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.documentlibrary.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.documentlibrary.model.DLSync;
import com.liferay.portlet.documentlibrary.model.DLSyncModel;
import com.liferay.portlet.documentlibrary.model.DLSyncSoap;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the DLSync service. Represents a row in the &quot;DLSync&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.documentlibrary.model.DLSyncModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DLSyncImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DLSyncImpl
 * @see com.liferay.portlet.documentlibrary.model.DLSync
 * @see com.liferay.portlet.documentlibrary.model.DLSyncModel
 * @generated
 */
@JSON(strict = true)
public class DLSyncModelImpl extends BaseModelImpl<DLSync>
	implements DLSyncModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a d l sync model instance should use the {@link com.liferay.portlet.documentlibrary.model.DLSync} interface instead.
	 */
	public static final String TABLE_NAME = "DLSync";
	public static final Object[][] TABLE_COLUMNS = {
			{ "syncId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "fileId", Types.BIGINT },
			{ "repositoryId", Types.BIGINT },
			{ "parentFolderId", Types.BIGINT },
			{ "event", Types.VARCHAR },
			{ "type_", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table DLSync (syncId LONG not null primary key,companyId LONG,createDate DATE null,modifiedDate DATE null,fileId LONG,repositoryId LONG,parentFolderId LONG,event VARCHAR(75) null,type_ VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table DLSync";
	public static final String ORDER_BY_JPQL = " ORDER BY dlSync.companyId ASC, dlSync.repositoryId ASC, dlSync.modifiedDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY DLSync.companyId ASC, DLSync.repositoryId ASC, DLSync.modifiedDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.documentlibrary.model.DLSync"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.documentlibrary.model.DLSync"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portlet.documentlibrary.model.DLSync"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long FILEID_COLUMN_BITMASK = 2L;
	public static long MODIFIEDDATE_COLUMN_BITMASK = 4L;
	public static long REPOSITORYID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static DLSync toModel(DLSyncSoap soapModel) {
		DLSync model = new DLSyncImpl();

		model.setSyncId(soapModel.getSyncId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setFileId(soapModel.getFileId());
		model.setRepositoryId(soapModel.getRepositoryId());
		model.setParentFolderId(soapModel.getParentFolderId());
		model.setEvent(soapModel.getEvent());
		model.setType(soapModel.getType());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<DLSync> toModels(DLSyncSoap[] soapModels) {
		List<DLSync> models = new ArrayList<DLSync>(soapModels.length);

		for (DLSyncSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.documentlibrary.model.DLSync"));

	public DLSyncModelImpl() {
	}

	public long getPrimaryKey() {
		return _syncId;
	}

	public void setPrimaryKey(long primaryKey) {
		setSyncId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_syncId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return DLSync.class;
	}

	public String getModelClassName() {
		return DLSync.class.getName();
	}

	@JSON
	public long getSyncId() {
		return _syncId;
	}

	public void setSyncId(long syncId) {
		_syncId = syncId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_columnBitmask |= MODIFIEDDATE_COLUMN_BITMASK;

		if (_originalModifiedDate == null) {
			_originalModifiedDate = _modifiedDate;
		}

		_modifiedDate = modifiedDate;
	}

	public Date getOriginalModifiedDate() {
		return _originalModifiedDate;
	}

	@JSON
	public long getFileId() {
		return _fileId;
	}

	public void setFileId(long fileId) {
		_columnBitmask |= FILEID_COLUMN_BITMASK;

		if (!_setOriginalFileId) {
			_setOriginalFileId = true;

			_originalFileId = _fileId;
		}

		_fileId = fileId;
	}

	public long getOriginalFileId() {
		return _originalFileId;
	}

	@JSON
	public long getRepositoryId() {
		return _repositoryId;
	}

	public void setRepositoryId(long repositoryId) {
		_columnBitmask |= REPOSITORYID_COLUMN_BITMASK;

		if (!_setOriginalRepositoryId) {
			_setOriginalRepositoryId = true;

			_originalRepositoryId = _repositoryId;
		}

		_repositoryId = repositoryId;
	}

	public long getOriginalRepositoryId() {
		return _originalRepositoryId;
	}

	@JSON
	public long getParentFolderId() {
		return _parentFolderId;
	}

	public void setParentFolderId(long parentFolderId) {
		_parentFolderId = parentFolderId;
	}

	@JSON
	public String getEvent() {
		if (_event == null) {
			return StringPool.BLANK;
		}
		else {
			return _event;
		}
	}

	public void setEvent(String event) {
		_event = event;
	}

	@JSON
	public String getType() {
		if (_type == null) {
			return StringPool.BLANK;
		}
		else {
			return _type;
		}
	}

	public void setType(String type) {
		_type = type;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public DLSync toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (DLSync)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					DLSync.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		DLSyncImpl dlSyncImpl = new DLSyncImpl();

		dlSyncImpl.setSyncId(getSyncId());
		dlSyncImpl.setCompanyId(getCompanyId());
		dlSyncImpl.setCreateDate(getCreateDate());
		dlSyncImpl.setModifiedDate(getModifiedDate());
		dlSyncImpl.setFileId(getFileId());
		dlSyncImpl.setRepositoryId(getRepositoryId());
		dlSyncImpl.setParentFolderId(getParentFolderId());
		dlSyncImpl.setEvent(getEvent());
		dlSyncImpl.setType(getType());

		dlSyncImpl.resetOriginalValues();

		return dlSyncImpl;
	}

	public int compareTo(DLSync dlSync) {
		int value = 0;

		if (getCompanyId() < dlSync.getCompanyId()) {
			value = -1;
		}
		else if (getCompanyId() > dlSync.getCompanyId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getRepositoryId() < dlSync.getRepositoryId()) {
			value = -1;
		}
		else if (getRepositoryId() > dlSync.getRepositoryId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getModifiedDate(), dlSync.getModifiedDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		DLSync dlSync = null;

		try {
			dlSync = (DLSync)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = dlSync.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		DLSyncModelImpl dlSyncModelImpl = this;

		dlSyncModelImpl._originalCompanyId = dlSyncModelImpl._companyId;

		dlSyncModelImpl._setOriginalCompanyId = false;

		dlSyncModelImpl._originalModifiedDate = dlSyncModelImpl._modifiedDate;

		dlSyncModelImpl._originalFileId = dlSyncModelImpl._fileId;

		dlSyncModelImpl._setOriginalFileId = false;

		dlSyncModelImpl._originalRepositoryId = dlSyncModelImpl._repositoryId;

		dlSyncModelImpl._setOriginalRepositoryId = false;

		dlSyncModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DLSync> toCacheModel() {
		DLSyncCacheModel dlSyncCacheModel = new DLSyncCacheModel();

		dlSyncCacheModel.syncId = getSyncId();

		dlSyncCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			dlSyncCacheModel.createDate = createDate.getTime();
		}
		else {
			dlSyncCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dlSyncCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dlSyncCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dlSyncCacheModel.fileId = getFileId();

		dlSyncCacheModel.repositoryId = getRepositoryId();

		dlSyncCacheModel.parentFolderId = getParentFolderId();

		dlSyncCacheModel.event = getEvent();

		String event = dlSyncCacheModel.event;

		if ((event != null) && (event.length() == 0)) {
			dlSyncCacheModel.event = null;
		}

		dlSyncCacheModel.type = getType();

		String type = dlSyncCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			dlSyncCacheModel.type = null;
		}

		return dlSyncCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{syncId=");
		sb.append(getSyncId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", fileId=");
		sb.append(getFileId());
		sb.append(", repositoryId=");
		sb.append(getRepositoryId());
		sb.append(", parentFolderId=");
		sb.append(getParentFolderId());
		sb.append(", event=");
		sb.append(getEvent());
		sb.append(", type=");
		sb.append(getType());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.documentlibrary.model.DLSync");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>syncId</column-name><column-value><![CDATA[");
		sb.append(getSyncId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileId</column-name><column-value><![CDATA[");
		sb.append(getFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>repositoryId</column-name><column-value><![CDATA[");
		sb.append(getRepositoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentFolderId</column-name><column-value><![CDATA[");
		sb.append(getParentFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>event</column-name><column-value><![CDATA[");
		sb.append(getEvent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = DLSync.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			DLSync.class
		};
	private long _syncId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _originalModifiedDate;
	private long _fileId;
	private long _originalFileId;
	private boolean _setOriginalFileId;
	private long _repositoryId;
	private long _originalRepositoryId;
	private boolean _setOriginalRepositoryId;
	private long _parentFolderId;
	private String _event;
	private String _type;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private DLSync _escapedModelProxy;
}