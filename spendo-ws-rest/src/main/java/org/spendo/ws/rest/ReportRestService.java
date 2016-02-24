package org.spendo.ws.rest;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.spendo.persistence.CategoryStoreData;
import org.spendo.persistence.entity.SpExpenditureCategoryMast;
import org.spendo.commons.vo.json.ExpCategoryDetail;
import org.spendo.commons.vo.json.ExpEntityDetail;
import org.spendo.commons.vo.json.ExpenditureDetail;
import org.spendo.commons.vo.json.SPWSReportInput;
import org.spendo.commons.vo.json.SPWSReportOutput;
import org.spendo.commons.vo.json.SpReportOutput;


@Path("/report-rest-service")
public class ReportRestService {
	
	@POST
    @Produces("application/json")
	@Consumes("application/json")
	@Path("/expenditure-details")
	public Response getExpenditureDetails(SPWSReportInput spwsReportInput) {
		CategoryStoreData categoryStoreData = new CategoryStoreData();
		SpExpenditureCategoryMast spExpenditureCategoryMast = categoryStoreData.fetchCategoryData(2);
		return Response.ok().entity(formDummyOutput(spExpenditureCategoryMast)).build();
	}
	
	private SPWSReportOutput formDummyOutput(SpExpenditureCategoryMast spExpenditureCategoryMast) {
		SPWSReportOutput spWSReportOutput = new SPWSReportOutput();
		SpReportOutput spReportOutput = new SpReportOutput();
		ExpenditureDetail expenditureDetail = new ExpenditureDetail();
		List<ExpCategoryDetail> expenditureDetailList = expenditureDetail.getExpCategoryDetail();
		ExpCategoryDetail expCategoryDetail = new ExpCategoryDetail();
		expCategoryDetail.setCategoryID(spExpenditureCategoryMast.getExpCategoryId());
		expCategoryDetail.setCategoryName(spExpenditureCategoryMast.getCategoryName());
		expCategoryDetail.setTotalExpCategoryAmount(2000.0);
		List<ExpEntityDetail> expEntityDetailList = expCategoryDetail.getExpEntityDetail();
		ExpEntityDetail expEntityDetail = new ExpEntityDetail();
		expEntityDetail.setEntityID(1);
		expEntityDetail.setEntityName("Reliance Fresh");
		expEntityDetail.setTransactionDate(new Date(System.currentTimeMillis()));
		expEntityDetail.setTransactionID(132211);
		expEntityDetail.setAmount(2000.0);
		expEntityDetailList.add(expEntityDetail);
		expenditureDetailList.add(expCategoryDetail);
		spReportOutput.setExpenditureDetail(expenditureDetail);
		spWSReportOutput.setSpReportOutput(spReportOutput);
		return spWSReportOutput;
	}
}
