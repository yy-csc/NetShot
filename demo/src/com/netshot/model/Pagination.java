package com.netshot.model;

/* 
 *(C) Copyright CSC Corporation Limited 2007. 
 *    All rights reserved. CSC Confidential   
 *  
 */

import java.util.List;

/**
 * Pagination List class.
 * 
 * @author <a href="mailto:whu3@csc.com">HU Wenwei</a>
 */
public class Pagination<T> {

	public interface Parameters {
		String SORT = "sort";
		String PAGE = "page";
		String ASC = "asc";
		String DESC = "desc";
		String DIRECTION = "dir";
		String SIZE = "pagesize";
	}

	static public enum SortOrder {
		ASCENDING, DESCENDING
	};

	static public int DEFAULT_PAGE_SIZE = 25;

	/** current page index, starts at 0 */
	private int index;

	/** number of results per page */
	private int pageSize;

	/** total number of results(rows) */
	private long totalSize;

	/** list of results (rows found ) in the current query */
	private List<T> list;

	/** default sorting order */
	private SortOrder sortDirection = SortOrder.ASCENDING;

	/** sort criteria */
	private String sortCriterion;

	public Pagination() {
		this.pageSize = DEFAULT_PAGE_SIZE;
		this.index = 0;
	}

	public Pagination(int pageSize) {
		this.pageSize = pageSize != 0 ? pageSize : DEFAULT_PAGE_SIZE;
		index = 0;
	}

	public int getFirstRecordIndex() {
		return index * pageSize;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> results) {
		this.list = results;
	}

	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(long total) {
		this.totalSize = total;
	}

	public int getTotalPages() {
		return (int) Math.ceil(((double) totalSize) / pageSize);
	}

	public int getPageNumber() {
		return index + 1;
	}

	public String getSortCriterion() {
		return sortCriterion;
	}

	public SortOrder getSortDir() {
		return sortDirection;
	}

	public void setSortCriterion(String sortCriterion) {
		this.sortCriterion = sortCriterion;
	}

	public void setSortDir(SortOrder sortDirection) {
		this.sortDirection = sortDirection;
	}

	public void setSortCriterion(String tableId, String sortCriterion) {
		this.sortCriterion = sortCriterion;
	}
}
