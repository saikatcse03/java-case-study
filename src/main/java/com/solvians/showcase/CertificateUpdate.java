package com.solvians.showcase;

import java.time.LocalDate;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class CertificateUpdate {

    private final ISINGenerator isinGenerator = new ISINGenerator();
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    public CertificateUpdate() {
    }

    public Callable<String> getCertificateUpdate() {
        return () -> {
            String ISIN = isinGenerator.generateISIN();
            double bidPrice = random.nextDouble(100.00, 200.00);
            int bidSize = random.nextInt(1000, 5000);
            double askPrice = random.nextDouble(100.00, 200.00);
            int askSize = random.nextInt(1000, 10000);

            return String.format("%d,%s,%.2f,%d,%.2f,%d",
                    System.currentTimeMillis(),
                    ISIN,
                    bidPrice,
                    bidSize,
                    askPrice,
                    askSize);
        };
    }
}
