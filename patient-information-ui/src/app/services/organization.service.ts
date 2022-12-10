import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Organization } from '../models/organization.model';
import { Page } from '../models/page.model';

const API_URL = environment.apiUrl;
const DEFAULT_PAGE = 0;
const DEFAULT_SORT = "updateDate,desc";
const DEFAULT_PAGE_SIZE = environment.defaultPageSize;

const ORGANIZATIONS_URL = `${API_URL}/api/v1/organizations`;

@Injectable({
  providedIn: 'root'
})
export class OrganizationService {

  constructor(private httpClient: HttpClient) { }

  getOrganizationsPage(page = DEFAULT_PAGE, size = DEFAULT_PAGE_SIZE): Observable<Page<Organization>> {
    return this.httpClient.get<Page<Organization>>(ORGANIZATIONS_URL, { params: { page, size , sort: DEFAULT_SORT} });
  }

  createOrganization(organization: Organization): Observable<Organization> {
    return this.httpClient.post<Organization>(ORGANIZATIONS_URL, organization);
  }

}
