package com.xieyao.tvdemo.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by xieyao on 2019-10-11.
 */
public class MovieResult {

	@SerializedName("page")
	private int page;

	@SerializedName("total_pages")
	private int totalPages;

	@SerializedName("results")
	private List<Movie> results;

	@SerializedName("total_results")
	private int totalResults;

	private int index;

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public void setResults(List<Movie> results){
		this.results = results;
	}

	public List<Movie> getResults(){
		return results;
	}

	public void setTotalResults(int totalResults){
		this.totalResults = totalResults;
	}

	public int getTotalResults(){
		return totalResults;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
 	public String toString(){
		return
			"MovieResult{" +
			"index = '" + index + '\'' +
			"page = '" + page + '\'' +
			",total_pages = '" + totalPages + '\'' +
			",results = '" + results + '\'' +
			",total_results = '" + totalResults + '\'' +
			"}";
		}
}