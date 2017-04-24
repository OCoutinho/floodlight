package net.floodlightcontroller.statistics;


import org.projectfloodlight.openflow.types.U64;

public class FlowRuleStats {
	private long duration;
	private U64 byteCount;
	private U64 packetCount;
	
	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public U64 getByteCount() {
		return byteCount;
	}

	public void setByteCount(U64 byteCount) {
		this.byteCount = byteCount;
	}

	public U64 getPacketCount() {
		return packetCount;
	}

	public void setPacketCount(U64 packetCount) {
		this.packetCount = packetCount;
	}

	private FlowRuleStats(U64 bytes, U64 packets,long duration) {
		this.byteCount = bytes;
		this.packetCount = packets;
		this.duration = duration;
	}
	
	public static FlowRuleStats of(U64 bytes, U64 packets,long duration) {
		if (bytes == null) {
			throw new IllegalArgumentException("byteCount cannot be null");
		}
		if (packets == null) {
			throw new IllegalArgumentException("packetCount cannot be null");
		}
		return new FlowRuleStats(bytes,packets,duration);
	}
}
