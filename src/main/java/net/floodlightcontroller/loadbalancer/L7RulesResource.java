package net.floodlightcontroller.loadbalancer;

import java.io.IOException;
import java.util.Collection;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.MappingJsonFactory;


public class L7RulesResource extends ServerResource {
	protected static Logger log = LoggerFactory.getLogger(L7RulesResource.class);
	
	@Get("json")
    public Collection <L7Rule> retrieve() {
        ILoadBalancerService lbs =
                (ILoadBalancerService)getContext().getAttributes().
                    get(ILoadBalancerService.class.getCanonicalName());
        
        String ruleId = (String) getRequestAttributes().get("rule");
        if (ruleId!=null)
            return lbs.listL7Rule(ruleId);
        else
            return lbs.listL7Rules();
    }
    
    @Put
    @Post
    public L7Rule createL7Rule(String postData) {

        L7Rule l7_rule=null;
        try {
        	l7_rule=jsonToL7Rule(postData);
        } catch (IOException e) {
            log.error("Could not parse JSON {}", e.getMessage());
        }
        
        ILoadBalancerService lbs =
                (ILoadBalancerService)getContext().getAttributes().
                    get(ILoadBalancerService.class.getCanonicalName());
        
        String ruleId = (String) getRequestAttributes().get("rule");
        if (ruleId != null)
            return lbs.updateL7Rule(l7_rule);
        else
            return lbs.createL7Rule(l7_rule);
    }
    
    @Delete
    public int removeL7Rule() {
        
        String ruleId = (String) getRequestAttributes().get("rule");
        
        ILoadBalancerService lbs =
                (ILoadBalancerService)getContext().getAttributes().
                    get(ILoadBalancerService.class.getCanonicalName());

        return lbs.removeL7Rule(ruleId);
    }

    protected L7Rule jsonToL7Rule(String json) throws IOException {
        
        if (json==null) return null;
        
        MappingJsonFactory f = new MappingJsonFactory();
        JsonParser jp;
        L7Rule l7_rule = new L7Rule();
        
        try {
            jp = f.createParser(json);
        } catch (JsonParseException e) {
            throw new IOException(e);
        }
        
        jp.nextToken();
        if (jp.getCurrentToken() != JsonToken.START_OBJECT) {
            throw new IOException("Expected START_OBJECT");
        }
        
        while (jp.nextToken() != JsonToken.END_OBJECT) {
            if (jp.getCurrentToken() != JsonToken.FIELD_NAME) {
                throw new IOException("Expected FIELD_NAME");
            }
            
            String n = jp.getCurrentName();
            jp.nextToken();
            if (jp.getText().equals("")) 
                continue;
 
            if (n.equals("id")) {
            	l7_rule.id = jp.getText();
                continue;
            } 
            if (n.equals("policy_id")) {
            	l7_rule.policyId = jp.getText();
                continue;
            } 
            if (n.equals("type")) {
            	String temp = jp.getText();
            	if(temp.equalsIgnoreCase("Filetype")){
            		l7_rule.type = 1;
            	} else
            		l7_rule.type = 0;
            	
                continue;
            }
            if (n.equals("value")) {
            	l7_rule.value = jp.getText();
                continue;
            } 
            
            log.warn("Unrecognized field {} in " +
                    "parsing l7Rules", 
                    jp.getText());
        }
        jp.close();
        
        return l7_rule;
    }
}
