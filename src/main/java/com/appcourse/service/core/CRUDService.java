package com.appcourse.service.core;

import com.appcourse.payload.Response;
import com.appcourse.service.marker.Creationable;
import com.appcourse.service.marker.Modifiable;

/**
 * @I - id of entities
 * @R - outcome response type which accessible data for usage
 * @C - incoming object that is request for creation
 * @U - incoming object that is request for update
 **/

public interface CRUDService <
        I,
        R extends Response,
        C extends Creationable,
        U extends Modifiable
        > extends Service{
    R create (C c);

    R get (I i);

    R modify (I id, U u);

    R delete (I id);
}
