import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { InfiniteScrollCustomEvent, IonInfiniteScroll, IonModal } from '@ionic/angular';
import { OverlayEventDetail } from '@ionic/core';
import { Organization } from '../models/organization.model';
import { OrganizationService } from '../services/organization.service';

@Component({
  selector: 'app-folder',
  templateUrl: './folder.page.html',
  styleUrls: ['./folder.page.scss'],
})
export class FolderPage implements OnInit {
  @ViewChild(IonModal) createOrganizationModal: IonModal | undefined;
  @ViewChild(IonInfiniteScroll) infinityScroll: IonInfiniteScroll | undefined;

  public folder!: string;

  organizationName = '';
  organizations: Organization[] = [];
  currentPage = 0;
  totalPages = 1;
  totalResults = 0;

  constructor(private activatedRoute: ActivatedRoute, private organizationService: OrganizationService) { }

  ngOnInit() {
    this.folder = this.activatedRoute.snapshot.paramMap.get('id') as string;
    this.loadOrganizations();
  }

  cancelCreateOrganization(): void {
    this.createOrganizationModal?.dismiss(null, 'cancel');
  }

  confirmCreateOrganization(): void {
    this.createOrganizationModal?.dismiss(this.organizationName, 'confirm');
  }

  onDismissCreateOrganization(event: any): void {
    const ev = event as CustomEvent<OverlayEventDetail<string>>;
    if (ev.detail.role === 'confirm') {
      const organizationName = ev.detail.data as string;
      const organization: Organization = { name: organizationName };

      this.organizationService.createOrganization(organization).subscribe(o => {
        this.organizations = [];
        this.loadOrganizations();
        if(this.infinityScroll !== undefined){
          this.infinityScroll.disabled = false;
        }
      }
      );
    }

    // clean up
    this.organizationName = '';
  }

  loadOrganizations(page = 0, event?: InfiniteScrollCustomEvent): void {
    if (page < this.totalPages) {
      this.organizationService.getOrganizationsPage(page).subscribe(p => {
        this.organizations.push(...p.content);
        this.currentPage = p.number;
        this.totalPages = p.totalPages;
        this.totalResults = p.totalElements;

        event?.target.complete();
        if (this.currentPage === (this.totalPages - 1) && event !== undefined) {
          event.target.disabled = true;
        }
      });
    }
  }

  public loadMoreOrganizations(event: Event): void {
    const infiniteScrollEvent = event as InfiniteScrollCustomEvent;
    this.loadOrganizations(this.currentPage + 1, infiniteScrollEvent);
  }

}
