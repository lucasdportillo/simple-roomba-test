package com.yoti.roomba.repository;

import com.yoti.roomba.service.CleanInfoReport;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "roomba_output")
public class RoombaOutput {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Convert(converter = OutputJsonConverter.class)
    @Column(name = "data")
    private RoombaOutputData data;

    public RoombaOutput() {
    }

    public static RoombaOutput from(CleanInfoReport cleanInfoReport) {
        RoombaOutput roombaOutput = new RoombaOutput();
        RoombaOutputData data = new RoombaOutputData();
        roombaOutput.setData(data);

        data.setFinalPosition(cleanInfoReport.getFinalPosition());
        data.setTotalCleanPatches(cleanInfoReport.getTotalPatches());

        return roombaOutput;
    }
}
