package com.joshuaharwood.cifparser.parsing.files;

import com.joshuaharwood.cifparser.parsing.lines.model.CifRecord;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

/**
 * A processor accepting a CIF file, and returning {@link CifRecord}s in format {@link O}.
 *
 * @param <I> The type that the CIF file will be provided to the processor as.
 * @param <O> The type that the processor provides {@link CifRecord}s as. This could be a
 *            {@link Collection} or {@link CompletableFuture}, for example.
 */
public interface CifProcessor<I, O> {

  O process(I input) throws Exception;
}
