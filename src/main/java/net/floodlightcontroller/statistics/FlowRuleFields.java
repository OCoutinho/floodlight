package net.floodlightcontroller.statistics;

import java.util.Date;

import org.projectfloodlight.openflow.types.DatapathId;
import org.projectfloodlight.openflow.types.OFPort;
import org.projectfloodlight.openflow.types.U64;

public class FlowRuleFields {
	private DatapathId id;
	private OFPort pt;
	private U64 speed;
	private U64 rx;
	private U64 tx;
	private Date time;
	private U64 rxValue;
	private U64 txValue;
	
	//private SwitchPortBandwidth() {}
	private FlowRuleFields(DatapathId d, OFPort p, U64 s, U64 rx, U64 tx, U64 rxValue, U64 txValue) {
		id = d;
		pt = p;
		speed = s;
		this.rx = rx;
		this.tx = tx;
		time = new Date();
		this.rxValue = rxValue;
		this.txValue = txValue;
	}
	
	public static FlowRuleFields of(DatapathId d, OFPort p, U64 s, U64 rx, U64 tx, U64 rxValue, U64 txValue) {
		if (d == null) {
			throw new IllegalArgumentException("Datapath ID cannot be null");
		}
		if (p == null) {
			throw new IllegalArgumentException("Port cannot be null");
		}
		if (s == null) {
			throw new IllegalArgumentException("Link speed cannot be null");
		}
		if (rx == null) {
			throw new IllegalArgumentException("RX bandwidth cannot be null");
		}
		if (tx == null) {
			throw new IllegalArgumentException("TX bandwidth cannot be null");
		}
		if (rxValue == null) {
			throw new IllegalArgumentException("RX value cannot be null");
		}
		if (txValue == null) {
			throw new IllegalArgumentException("TX value cannot be null");
		}
		return new FlowRuleFields(d, p, s, rx, tx, rxValue, txValue);
	}

}
