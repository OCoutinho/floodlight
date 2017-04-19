package net.floodlightcontroller.statistics;

import net.floodlightcontroller.core.module.IFloodlightService;
import net.floodlightcontroller.core.types.NodePortTuple;

import org.projectfloodlight.openflow.protocol.match.Match;
import org.projectfloodlight.openflow.types.DatapathId;
import org.projectfloodlight.openflow.types.OFPort;
import org.projectfloodlight.openflow.types.U64;
import org.sdnplatform.sync.internal.util.Pair;

import java.util.Map;

public interface IStatisticsService extends IFloodlightService {
	
	public Map<Pair<Match,Integer>, U64> getFlowBytesCount();

	public SwitchPortBandwidth getBandwidthConsumption(DatapathId dpid, OFPort p);
		
	public Map<NodePortTuple, SwitchPortBandwidth> getBandwidthConsumption();
	
	public void collectStatistics(boolean collect);
}
