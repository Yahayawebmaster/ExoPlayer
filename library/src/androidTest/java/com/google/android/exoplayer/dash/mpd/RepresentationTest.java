/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.android.exoplayer.dash.mpd;

import com.google.android.exoplayer.Format;
import com.google.android.exoplayer.dash.mpd.SegmentBase.SingleSegmentBase;
import com.google.android.exoplayer.util.MimeTypes;

import junit.framework.TestCase;

/**
 * Unit test for {@link Representation}.
 */
public class RepresentationTest extends TestCase {

  public void testGetCacheKey() {
    String uri = "http://www.google.com";
    SegmentBase base = new SingleSegmentBase(new RangedUri(uri, null, 0, 1), 1, 0, uri, 1, 1);
    Format format = Format.createVideoContainerFormat("0", MimeTypes.APPLICATION_MP4,
        MimeTypes.VIDEO_H264, 2500000, 1920, 1080, Format.NO_VALUE, null);
    Representation representation = Representation.newInstance("test_stream_1", 3, format, base);
    assertEquals("test_stream_1.0.3", representation.getCacheKey());

    format = Format.createVideoContainerFormat("150", MimeTypes.APPLICATION_MP4,
        MimeTypes.VIDEO_H264, 2500000, 1920, 1080, Format.NO_VALUE, null);
    representation = Representation.newInstance("test_stream_1", -1, format, base);
    assertEquals("test_stream_1.150.-1", representation.getCacheKey());
  }

}
