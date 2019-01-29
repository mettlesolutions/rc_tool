package com.Mettles.RCClient;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import gov.hhs.cms.esmd.jaxb.util.ReviewContractorMarshallerUtil;
import gov.hhs.cms.esmd.rc.client.bean.LoginBean;
import gov.hhs.cms.esmd.rc.client.bean.ValidationFailureBean;
import gov.hhs.cms.esmd.rc.client.bean.emdr.abmac.ClaimInfo;
import gov.hhs.cms.esmd.rc.client.bean.emdr.abmac.EMDRABMacSchemaBean;
import gov.hhs.cms.esmd.rc.client.bean.emdr.abmac.LetterDetails;
import gov.hhs.cms.esmd.rc.client.bean.emdr.abmac.PointOfContact;
import gov.hhs.cms.esmd.rc.client.bean.emdr.abmac.ProviderDetails;
import gov.hhs.cms.esmd.rc.client.bean.emdr.commontypes.Address;
import gov.hhs.cms.esmd.rc.client.bean.emdr.commontypes.AttachmentDetails;
import gov.hhs.cms.esmd.rc.client.bean.emdr.commontypes.Name;
import gov.hhs.cms.esmd.rc.client.bean.emdr.commontypes.ReceiverDetails;
import gov.hhs.cms.esmd.rc.client.bean.emdr.commontypes.SenderDetails;
import gov.hhs.cms.esmd.rc.client.bean.emdr.commontypes.Telephone;
import gov.hhs.cms.esmd.rc.client.login.LoginDetails;
import gov.hhs.cms.esmd.rc.client.login.LoginImpl;
import gov.hhs.cms.esmd.rc.client.request.emdr.EMDRABMacProcessor;
import gov.hhs.cms.esmd.rc.client.request.emdr.ESMDManualSubmitEMDRRequestImpl;
import gov.hhs.cms.esmd.rc.client.sample.Message;
import gov.hhs.cms.esmd.rc.client.utililties.common.FileOperationUtil;
import gov.hhs.cms.esmd.rc.client.utililties.common.RandomValue;
import gov.hhs.cms.esmd.rc.client.utililties.configuration.ConfigurationManager;
import gov.hhs.cms.ois.esmd.v1.rc.config.ESMDConfig;
import gov.hhs.cms.ois.esmd.v1.rc.config.ESMDConfig.KeyStoreInfo;
import gov.hhs.cms.ois.esmd.v1.rc.config.SftpDetails;

public class RCClientProcessor {

	/**
	 * @param args
	 */
	 
	public void RCProcessor() {
		try {
		System.out.println("Start java");
		SftpDetails sf = new SftpDetails();
		sf.setHost("eft1.feps.cms.gov");
		sf.setPort(9022);
		sf.setEnvironmentId("T");
		sf.setEftFilePrefix("#EFT");
		KeyStoreInfo ks = new KeyStoreInfo();
		ks.setKeyStoreLocation("/home/ubuntu/config/rioc_gtwy_str");
		ks.setCertAlias("riocrc");
		ks.setEncKeyInfo("TYUnjVHDOBo=");
		ks.setEncKeyInfoExt("8+gsyRDQgFU=");
		LoginBean login = new LoginBean();
		login.setUserId("MADHURIMAPOLISHETTY");
		login.setPassword("WiT76982");
		Name sName = new Name();
		sName.setLastName("Finn");
		Address address = new Address();
		address.setAddress1("7718 dagny way");
		address.setCity("Columbia");
		address.setState("MD");
		address.setZipCode("94539");
		Telephone tel = new Telephone();
		tel.setTelephoneNumber("4086257048");
		LoginImpl limpl = new LoginImpl();
		LoginDetails lDetails = limpl.loginAndEncrypt(sf, ks, login);
		EMDRABMacSchemaBean emdr = new EMDRABMacSchemaBean();
		emdr.setCaseId("12345");
		emdr.setLetterDate("01/01/2019");
		ArrayList<File> files = new ArrayList<File>();
		files.add(new File("/home/ubuntu/Gateway_IG.pdf"));
		LetterDetails letterDetails = new LetterDetails();
		letterDetails.setResponseDate("01/01/2020");
		letterDetails.setResultsToBeDeliveredBy(2);
		letterDetails.setProgramName("esmd");
		letterDetails.setHippsCode("hips");
		List<ClaimInfo> claimInfoList = new ArrayList<ClaimInfo>();
		ClaimInfo claim = new ClaimInfo();
		claim.setClaimID("1234567890123");
		claim.setComments(null);
		claim.setBeneficiaryName(sName);
		claim.setRenderingProviderName(sName);
		claim.setDateOfBirth("01/01/1956");
		claim.setDateOfService("01/01/2019");
		claim.setSubscriberId("1234567");
		claim.setProcedureCode("abcdef");
        claimInfoList.add(claim);
		letterDetails.setClaimInfoList(claimInfoList);
		emdr.setLetterDetails(letterDetails);
	    emdr.setLetterId("B7MH9DOFCBNDK68YVXOAFWXYD");
		AttachmentDetails attachmentDetails = new AttachmentDetails();
		ArrayList<String> attachmentInformation = new ArrayList();
		attachmentInformation.add("Gateway_IG.pdf");
		attachmentDetails.setAttachmentInformation(attachmentInformation);
		emdr.setAttachmentDetails(attachmentDetails);
		ProviderDetails pd = new ProviderDetails();
		pd.setProviderNPI(1234567890);
		
		SenderDetails sd = new SenderDetails();
		sd.setJurisdictionName("region a");
		
		
		pd.setProviderAddress(address);
		pd.setProviderTelephone(tel);
		pd.setProviderName(sName);
		sd.setSenderTelephone(tel);
		sd.setSenderAddress(address);
		sd.setSenderName(sName);
		
		emdr.setSenderDetails(sd);
		ReceiverDetails rd = new ReceiverDetails();
		rd.setHihOID("2.16.840.1.113883.3.6037.3");
		emdr.setReceiverDetails(rd);
		PointOfContact pc = new PointOfContact();
		pc.setPOCName(sName);
		pc.setPOCAddress(address);
		pc.setPOCTelephone(tel);
		
		emdr.setPointOfContact(pc);
		emdr.setProviderDetails(pd);
		String configFile = "/home/ubuntu/config/esmd-rc-client-config.xml";
		String bConfigFile = "/home/ubuntu/config/rc-client-business-config.xml";
		EMDRABMacProcessor emdrabMacProcessor = new EMDRABMacProcessor(configFile, bConfigFile);
		Object emdrRequestMetadataObject = emdrabMacProcessor.generateABMacEMDRMetadataObject(emdr);
		ESMDManualSubmitEMDRRequestImpl req = new ESMDManualSubmitEMDRRequestImpl(configFile, bConfigFile);
		Message mess = req.generateEMDRPackage(emdr, files);
		FileOperationUtil fileOperationUtil = new FileOperationUtil(configFile);
		String randomAlphaNumeric = RandomValue.randomAlphaNumericValue();
	      String datemmddyyyy = new SimpleDateFormat("MMddyy").format(new Date());
	      String timehhmmss = new SimpleDateFormat("HHmmss").format(new Date()) + "0";
	      ESMDConfig conf = ConfigurationManager.loadXMLConfiguration(configFile);
	      String uniqueID = req.generateUniqueID(randomAlphaNumeric, datemmddyyyy, timehhmmss);
	      String requestXMLFileName = ReviewContractorMarshallerUtil.generateXMLFile(emdrRequestMetadataObject, conf.getOutboundConfig().getTempDirectory().trim(),
	    		  "R", uniqueID, "eMDRRequest", "/", "xml");
	      File requestXMLFile = new File(requestXMLFileName);
		Collection<File> tempDirPayloadFiles = fileOperationUtil.copyPayloadFilesToTempDirectory(files);
		List<ValidationFailureBean> vFailures = mess.getValidationFailureBeanList();
		for (java.util.Iterator<ValidationFailureBean> iterator = vFailures.iterator(); iterator.hasNext();) {
			ValidationFailureBean validationFailureBean = (ValidationFailureBean) iterator.next();
			String failure = validationFailureBean.getFailureMessage();
			System.out.println("Failure Message is " + failure);
		}
		limpl.decryptAndLogin(lDetails, sf, ks);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("done java");
		
	}

}
