/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2025 Dmitry Degrave
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.dnaerys.client;

import org.dnaerys.cluster.grpc.Chromosome;

import java.util.ArrayList;
import java.util.List;

public class ContigsMapping {
    static org.dnaerys.cluster.grpc.Chromosome contigName2GrpcChr(String contig) {
        switch (contig) {
            case "1": return (Chromosome.CHR_1);
            case "2": return (Chromosome.CHR_2);
            case "3": return (Chromosome.CHR_3);
            case "4": return (Chromosome.CHR_4);
            case "5": return (Chromosome.CHR_5);
            case "6": return (Chromosome.CHR_6);
            case "7": return (Chromosome.CHR_7);
            case "8": return (Chromosome.CHR_8);
            case "9": return (Chromosome.CHR_9);
            case "10": return (Chromosome.CHR_10);
            case "11": return (Chromosome.CHR_11);
            case "12": return (Chromosome.CHR_12);
            case "13": return (Chromosome.CHR_13);
            case "14": return (Chromosome.CHR_14);
            case "15": return (Chromosome.CHR_15);
            case "16": return (Chromosome.CHR_16);
            case "17": return (Chromosome.CHR_17);
            case "18": return (Chromosome.CHR_18);
            case "19": return (Chromosome.CHR_19);
            case "20": return (Chromosome.CHR_20);
            case "21": return (Chromosome.CHR_21);
            case "22": return (Chromosome.CHR_22);
            case "X": return (Chromosome.CHR_X);
            case "Y": return (Chromosome.CHR_Y);
            case "MT": return (Chromosome.CHR_MT);
            default: return (Chromosome.UNRECOGNIZED);
        }
    }

    static List<Chromosome> contigName2GrpcChr(String[] contigs) {
        ArrayList<Chromosome> res = new ArrayList<>(contigs.length);
        for (String chr : contigs) {
            res.add(contigName2GrpcChr(chr));
        }
        return res;
    }
}
