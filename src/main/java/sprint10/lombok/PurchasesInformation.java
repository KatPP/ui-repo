package sprint10.lombok;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

// Информация о покупках пользователя
@Data
@Builder
public class PurchasesInformation {
    // дата последней покупки
    private Date lastPurchase;
    // Общее количество покупок
    private long purchaseCounts = 0;
}


