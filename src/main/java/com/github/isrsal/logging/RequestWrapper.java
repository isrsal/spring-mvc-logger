/*
 * spring-mvc-logger logs requests/responses
 *
 * Copyright (c) 2012.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.isrsal.logging;

import org.apache.commons.io.input.TeeInputStream;
import org.springframework.mock.web.DelegatingServletInputStream;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class RequestWrapper extends HttpServletRequestWrapper {

    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private long id;


    public RequestWrapper(Long requestId, HttpServletRequest request) {
        super(request);
        this.id = requestId;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new DelegatingServletInputStream(new TeeInputStream(super.getInputStream(), bos));
    }

    public byte[] toByteArray(){
        return bos.toByteArray();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
