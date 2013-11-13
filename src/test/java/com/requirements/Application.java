package com.requirements;

import net.thucydides.core.annotations.Feature;

public class Application {
    @Feature
    public class Login {
        public class IndividualLogin {}
        public class LoginCSVTest {}
        
    }
    @Feature
    public class HandleRequests{
    	
    	public class HandleRequestsTest{}
    }
    @Feature
    public class ApproverReq{
    	
    	public class ApproverRequestsTest{}
    }
    
    @Feature
    public class RejectReq{
    	
    	public class RejectRequestsTest{}
    }
    
    @Feature
    public class AssignReq{
    	
    	public class AssignToTest{}
    }
    
    @Feature
    public class CancelAssignReq{
    	
    	public class CancelAssignToTest{}
    }
    
    @Feature
    public class UserAssignReq{
    	
    	public class AssignUserTest{}
    }
    
    @Feature
    public class CommAssignReq{
    	
    	public class CommAssignToTest{}
    }
    
    
    @Feature
    public class CheckForCompletedRequests{
     public class CheckIfYouCanCompleteARequestAfterYouCloseThePopUpMessage{}
    
    }
    
    @Feature
    public class CheckWithdrawSubmission{
     public class CheckIfYouCanWithdrawSubmission{}
    }
}