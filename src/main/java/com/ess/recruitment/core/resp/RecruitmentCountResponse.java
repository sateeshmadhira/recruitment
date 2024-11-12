package com.ess.recruitment.core.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecruitmentCountResponse {

    private long totalCount;
    private long totalActiveCount;
    private long inActiveCount;
    private long activeCount;
    private long yetToStartCount;
    private long onGoingCount;
    private long completedCount;
//    private long closedCount;
}
