package org.spendo.ws.rest;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.spendo.reportws.vo.json.ExpCategoryDetail;
import org.spendo.reportws.vo.json.ExpEntityDetail;
import org.spendo.reportws.vo.json.ExpenditureDetail;
import org.spendo.reportws.vo.json.SPWSReportInput;
import org.spendo.reportws.vo.json.SPWSReportOutput;
import org.spendo.reportws.vo.json.SpReportOutput;


@Path("/report-rest-service")
public class ReportRestService {
	
	@GET
    @Produces("application/json")
	@HeaderParam("Accept:application/oracle.com.cloud.common.Blackout+json")
	@Path("/expenditure-details")
	public Response getExpenditureDetails() {
		return Response.ok().entity(formDummyOutput()).build();
	}
	
	private SPWSReportOutput formDummyOutput() {
		SPWSReportOutput spWSReportOutput = new SPWSReportOutput();
		SpReportOutput spReportOutput = new SpReportOutput();
		ExpenditureDetail expenditureDetail = new ExpenditureDetail();
		List<ExpCategoryDetail> expenditureDetailList = expenditureDetail.getExpCategoryDetail();
		ExpCategoryDetail expCategoryDetail = new ExpCategoryDetail();
		expCategoryDetail.setCategoryID(1);
		expCategoryDetail.setCategoryName("Food");
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
