package com.ess.recruitment.core.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecruitmentCountResponse {

    private long totalCount;
    private long activeCount;
    private long inActiveCount;
    private long openCount;
    private long yetToStartCount;
    private long onGoingCount;
    private long completedCount;
//    private long closedCount;
}
