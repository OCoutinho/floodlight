package net.floodlightcontroller.loadbalancer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using=LBPoolStatsSerializer.class)
public class LBPoolStats {

	protected long packets;
	protected long totalBytes;
	protected int activeConnections;
	
	public LBPoolStats(){
		this.packets = 0;
		this.totalBytes = 0;
		this.activeConnections = 0;
	}

	public LBPoolStats getStats(){
		return this;
	}
	
	public long getPackets() {
		return packets;
	}

	public void setPackets(long packets) {
		this.packets = packets;
	}

	public void setTotalBytes(long totalBytes) {
		this.totalBytes = totalBytes;
	}
	
	public long getTotalBytes() {
		return totalBytes;
	}

	
	public int getActiveConnections() {
		return activeConnections;
	}
	
	
	public void setTotalBytes(int totalBytes) {
		this.totalBytes = totalBytes;
	}

	public void setActiveConnections(int activeConnections) {
		this.activeConnections = activeConnections;
	}

}
