#!/bin/bash

# SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
#
# SPDX-License-Identifier: AGPL-3.0-or-later

for i in `seq 1 30`; do
    cp "test-data.sql" "new-test-data-$i.sql"
    for j in `seq 1 70`; do
        new_j=$[$j + 70 * i]
        sed -i "s|($j,|($new_j,|" "new-test-data-$i.sql"
    done
done
