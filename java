import org.apache.commons.math3.transform.*;
import org.apache.commons.math3.complex.Complex;

public class FFTExample {
    public static void main(String[] args) {
        // Define the signal
        int N = 1000;                            // Number of samples
        double Fs = 1000;                        // Sampling frequency (Hz)
        double[] signal = new double[N];         // Signal array
        double[] time = new double[N];           // Time array
        double f = 50;                           // Signal frequency (Hz)
        for (int i = 0; i < N; i++) {
            time[i] = (double) i / Fs;           // Time in seconds
            signal[i] = Math.sin(2 * Math.PI * f * time[i]);  // Generate the signal (sine wave)
        }

        // Perform FFT
        FastFourierTransformer transformer = new FastFourierTransformer(DftNormalization.STANDARD);
        Complex[] frequencies = transformer.transform(signal, TransformType.FORWARD);

        // Plot the magnitude spectrum
        for (int i = 0; i < frequencies.length / 2; i++) {
            double magnitude = frequencies[i].abs() / N;  // Normalize magnitude
            double frequency = (double) i * Fs / N;        // Convert index to frequency
            System.out.println("Frequency: " + frequency + " Hz, Magnitude: " + magnitude);
        }
    }
}
